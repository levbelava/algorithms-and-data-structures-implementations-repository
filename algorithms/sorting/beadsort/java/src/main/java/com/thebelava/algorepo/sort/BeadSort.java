package com.thebelava.algorepo.sort;


public class BeadSort {

    public int[] sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        int maxElement = findMaxElement(inputData);
        byte[][] sortingDataStructure = setUpSortingDataStructure(inputData, maxElement);
        naturalSort(sortingDataStructure, maxElement);
        return calculateResult(sortingDataStructure, maxElement);
    }

    private int[] calculateResult(byte[][] sortingDataStructure, int maxElement) {
        int[] result = new int[sortingDataStructure.length];
        for (int i = 0; i < sortingDataStructure.length; i++) {
            for (int j = 0; j < maxElement; j++) {
                if (sortingDataStructure[i][j] == 1) {
                    result[i] = j + 1;
                }
            }
        }
        return result;
    }

    private void naturalSort(byte[][] sortingDataStructure, int maxElement) {
        for (int j = 0; j < maxElement; j++) {
            int sum = 0;
            for (int i = 0; i < sortingDataStructure.length; i++) {
                sum += sortingDataStructure[i][j];
                sortingDataStructure[i][j] = 0;
            }
            for (int i = sortingDataStructure.length - sum; i < sortingDataStructure.length; i++) {
                sortingDataStructure[i][j] = 1;
            }
        }
    }

    private byte[][] setUpSortingDataStructure(int[] inputData, int maxElement) {
        byte[][] result = new byte[inputData.length][maxElement];
        for (int i = 0; i < inputData.length; i++) {
            for (int j = 0; j < inputData[i]; j++) {
                result[i][j] = 1;
            }
        }
        return result;
    }

    private int findMaxElement(int[] inputData) {
        int result = 0;
        for (int i : inputData) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }

}
