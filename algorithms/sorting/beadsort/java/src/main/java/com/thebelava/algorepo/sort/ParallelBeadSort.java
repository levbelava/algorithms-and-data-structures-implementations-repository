package com.thebelava.algorepo.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.util.concurrent.Executors.newFixedThreadPool;


public class ParallelBeadSort {
    private final int max_thread_count;

    public ParallelBeadSort(int max_thread_count) {
        this.max_thread_count = max_thread_count;
    }

    public int[] sort(int[] inputData) throws InterruptedException {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        int maxElement = findMaxElement(inputData);
        byte[][] sortingDataStructure = setUpSortingDataStructure(inputData, maxElement);
        naturalSort(sortingDataStructure, maxElement);
        return calculateResult(sortingDataStructure, maxElement);
    }

    private int[] calculateResult(byte[][] sortingDataStructure, int maxElement) throws InterruptedException {
        int[] result = new int[sortingDataStructure.length];
        ExecutorService executor = newFixedThreadPool(min(sortingDataStructure.length, max_thread_count));
        for (int i = 0; i < sortingDataStructure.length; i++) {
            final int currentInputDataElement = i;
            executor.submit(() -> {
                for (int j = 0; j < maxElement; j++) {
                    if (sortingDataStructure[currentInputDataElement][j] == 1) {
                        result[currentInputDataElement] = j + 1;
                    }
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
        return result;
    }

    private void naturalSort(byte[][] sortingDataStructure, int maxElement) throws InterruptedException {
        ExecutorService executor = newFixedThreadPool(min(maxElement, max_thread_count));
        for (int j = 0; j < maxElement; j++) {
            final int currentValue = j;
            executor.submit(() -> {
                int sum = 0;
                for (int i = 0; i < sortingDataStructure.length; i++) {
                    sum += sortingDataStructure[i][currentValue];
                    sortingDataStructure[i][currentValue] = 0;
                }
                for (int i = sortingDataStructure.length - sum; i < sortingDataStructure.length; i++) {
                    sortingDataStructure[i][currentValue] = 1;
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
    }

    private byte[][] setUpSortingDataStructure(final int[] inputData, int maxElement) throws InterruptedException {
        final byte[][] result = new byte[inputData.length][maxElement];
        ExecutorService executor = newFixedThreadPool(min(inputData.length, max_thread_count));
        for (int i = 0; i < inputData.length; i++) {
            final int currentInputDataElement = i;
            executor.submit(() -> {
                for (int j = 0; j < inputData[currentInputDataElement]; j++) {
                    result[currentInputDataElement][j] = 1;
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
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
