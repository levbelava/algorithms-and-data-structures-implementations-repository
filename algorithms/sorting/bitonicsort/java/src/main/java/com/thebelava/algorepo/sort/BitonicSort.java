package com.thebelava.algorepo.sort;

/**
 * Works only with data structures which length is a power of 2
 **/
public class BitonicSort {

    public int[] sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        if (!inputDataLengthIsFactorOfTwo(inputData.length)){
            throw new IllegalArgumentException("Sorts only arrays with a number of elements that a power of 2!");
        }


        return null;
    }

    private boolean inputDataLengthIsFactorOfTwo(int length) {
        return (length & (length -1)) == 0;
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }

}
