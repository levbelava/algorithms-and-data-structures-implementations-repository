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

    private void bitonicSort(int[] data, int startingIndex, int amountToSort, boolean sortingDirection) throws InterruptedException {
        if (amountToSort < 2) {
            return;
        }
        int halfAmount = amountToSort / 2;
        bitonicSort(data, startingIndex, halfAmount, ASCENDING);
        bitonicSort(data, startingIndex + halfAmount, halfAmount, DESCENDING);
        bitonicMerge(data, startingIndex, amountToSort, sortingDirection);
    }

    private void bitonicMerge(int[] data, int startingIndex, int amountToMerge, boolean sortingDirection) throws InterruptedException {
        if (amountToMerge < 2) {
            return;
        }
        final int halfAmountToMerge = amountToMerge / 2;
        executeComparatorsInParallelMode(data, startingIndex, sortingDirection, halfAmountToMerge);
        bitonicMerge(data, startingIndex, halfAmountToMerge, sortingDirection);
        bitonicMerge(data, startingIndex + halfAmountToMerge, halfAmountToMerge, sortingDirection);
    }

    private void executeComparatorsInParallelMode(int[] data, int startingIndex, boolean sortingDirection, int halfAmountToMerge) throws InterruptedException {
        ExecutorService executor = newFixedThreadPool(halfAmountToMerge);
        for (int i = startingIndex; i < startingIndex + halfAmountToMerge; i++) {
            final int currentIndex = i;
            executor.submit(() -> compareAndSwap(data, currentIndex, currentIndex + halfAmountToMerge, sortingDirection));
        }
        executor.shutdown();
        executor.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
    }

    private void compareAndSwap(int[] data, int firstIndexToCompare, int secondIndexToCompare, boolean sortingDirection) {
        if ((data[firstIndexToCompare] > data[secondIndexToCompare] && sortingDirection == ASCENDING)
                ||
                (data[firstIndexToCompare] < data[secondIndexToCompare] && sortingDirection == DESCENDING)) {
            int temp = data[firstIndexToCompare];
            data[firstIndexToCompare] = data[secondIndexToCompare];
            data[secondIndexToCompare] = temp;
        }
    }

    private boolean inputDataLengthIsFactorOfTwo(int length) {
        return (length & (length - 1)) == 0;
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }
}
