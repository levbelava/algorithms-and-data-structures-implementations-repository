package com.thebelava.algorepo.sort;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.MAX_VALUE;
import static java.util.concurrent.Executors.newFixedThreadPool;


public class ParallelBitonicSort {
    private static final boolean ASCENDING = true;
    private static final boolean DESCENDING = false;

    public void sort(int[] inputData) throws InterruptedException {
        if (isNothingToSort(inputData)) {
            return;
        }
        if (!inputDataLengthIsFactorOfTwo(inputData.length)) {
            throw new IllegalArgumentException("Sorts only arrays with a number of elements that a power of 2!");
        }
        bitonicSort(inputData, 0, inputData.length, ASCENDING);
    }

    private void bitonicSort(int[] data, int startingElement, int amountToSort, boolean sortingDirection) throws InterruptedException {
        if (amountToSort < 2) {
            return;
        }
        int halfAmount = amountToSort / 2;
        bitonicSort(data, startingElement, halfAmount, ASCENDING);
        bitonicSort(data, startingElement + halfAmount, halfAmount, DESCENDING);
        bitonicMerge(data, startingElement, amountToSort, sortingDirection);
    }

    private void bitonicMerge(int[] data, int startingElement, int amountToMerge, boolean sortingDirection) throws InterruptedException {
        if (amountToMerge < 2) {
            return;
        }
        final int halfAmountToMerge = amountToMerge / 2;
        executeComparatorsInParallelMode(data, startingElement, sortingDirection, halfAmountToMerge);
        bitonicMerge(data, startingElement, halfAmountToMerge, sortingDirection);
        bitonicMerge(data, startingElement + halfAmountToMerge, halfAmountToMerge, sortingDirection);
    }

    private void executeComparatorsInParallelMode(int[] data, int startingElement, boolean sortingDirection, int halfAmountToMerge) throws InterruptedException {
        ExecutorService executor = newFixedThreadPool(halfAmountToMerge);
        for (int i = startingElement; i < startingElement + halfAmountToMerge; i++) {
            final int currentElement = i;
            executor.submit(() -> compareAndSwap(data, currentElement, currentElement + halfAmountToMerge, sortingDirection));
        }
        executor.shutdown();
        executor.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
    }

    private void compareAndSwap(int[] data, int firstToCompare, int secondToCompare, boolean sortingDirection) {
        if ((data[firstToCompare] > data[secondToCompare] && sortingDirection == ASCENDING)
                ||
                (data[firstToCompare] < data[secondToCompare] && sortingDirection == DESCENDING)) {
            int temp = data[firstToCompare];
            data[firstToCompare] = data[secondToCompare];
            data[secondToCompare] = temp;
        }
    }

    private boolean inputDataLengthIsFactorOfTwo(int length) {
        return (length & (length - 1)) == 0;
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }
}
