package com.thebelava.algorepo.sort;

/**
 * Works only with data structures which length is a power of 2
 **/
public class BitonicSort {
    private static final boolean ASCENDING = true;
    private static final boolean DESCENDING = false;

    public void sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return;
        }
        if (!inputDataLengthIsFactorOfTwo(inputData.length)) {
            throw new IllegalArgumentException("Sorts only arrays with a number of elements that a power of 2!");
        }
        bitonicSort(inputData, 0, inputData.length, ASCENDING);
    }

    private void bitonicSort(int[] data, int startingIndex, int amountToSort, boolean sortingDirection) {
        if (amountToSort < 2) {
            return;
        }
        int halfAmount = amountToSort / 2;
        bitonicSort(data, startingIndex, halfAmount, ASCENDING);
        bitonicSort(data, startingIndex + halfAmount, halfAmount, DESCENDING);
        bitonicMerge(data, startingIndex, amountToSort, sortingDirection);
    }

    private void bitonicMerge(int[] data, int startingIndex, int amountToMerge, boolean sortingDirection) {
        if (amountToMerge < 2) {
            return;
        }
        int halfAmount = amountToMerge / 2;
        for (int i = startingIndex; i < startingIndex + halfAmount; i++) {
            compareAndSwap(data, i, i + halfAmount, sortingDirection);
        }
        bitonicMerge(data, startingIndex, halfAmount, sortingDirection);
        bitonicMerge(data, startingIndex + halfAmount, halfAmount, sortingDirection);
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
