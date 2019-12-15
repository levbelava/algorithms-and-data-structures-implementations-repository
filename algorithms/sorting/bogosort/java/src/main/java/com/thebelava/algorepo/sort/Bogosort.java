package com.thebelava.algorepo.sort;


import java.util.Random;


public class Bogosort {
    private final Random random = new Random();

    public int[] sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        while (isNotSorted(inputData)) {
            shuffleRandomly(inputData);
        }
        return inputData;
    }

    private boolean isNotSorted(int[] inputData) {
        for (int i = 0; i < inputData.length - 1; i++) {
            if (inputData[i] > inputData[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private void shuffleRandomly(int[] inputData) {
        for (int i = 0; i < inputData.length; i++) {
            int currentValue = inputData[i];
            int randomIndex = random.nextInt(inputData.length);
            inputData[i] = inputData[randomIndex];
            inputData[randomIndex] = currentValue;
        }
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }

}
