package com.thebelava.algorepo.sort;


public class QuickSort {

    public void sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return;
        }
        quickSort(inputData, 0, inputData.length - 1);
    }

    private void quickSort(int[] inputData, int lowInputIndex, int highInputIndex) {
        if (lowInputIndex < highInputIndex) {
            int partitionIndex = doHoarePartitioning(inputData, lowInputIndex, highInputIndex);
            quickSort(inputData, lowInputIndex, partitionIndex);
            quickSort(inputData, partitionIndex + 1, highInputIndex);
        }
    }

    private int doHoarePartitioning(int[] inputData, int lowInputIndex, int highInputIndex) {
        int pivotElementValue = inputData[Math.round((lowInputIndex + highInputIndex) / 2)];
        int currentLowIndex = lowInputIndex - 1;
        int currentHighIndex = highInputIndex + 1;
        while (true) {
            do {
                currentLowIndex++;
            } while (inputData[currentLowIndex] < pivotElementValue);

            do {
                currentHighIndex--;
            } while (inputData[currentHighIndex] > pivotElementValue);

            if (currentLowIndex < currentHighIndex) {
                swapElements(inputData, currentLowIndex, currentHighIndex);
            } else {
                return currentHighIndex;
            }
        }
    }

    private void swapElements(int[] inputData, int currentLowIndex, int currentHighIndex) {
        int temp = inputData[currentLowIndex];
        inputData[currentLowIndex] = inputData[currentHighIndex];
        inputData[currentHighIndex] = temp;
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }

}
