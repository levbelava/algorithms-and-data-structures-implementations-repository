package com.thebelava.algorepo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class QuickSortTest {
    private final QuickSort quickSort = new QuickSort();

    @Test
    public void verifiesNullInput() {
        quickSort.sort(null);
    }

    @Test
    public void verifiesZeroElements() {
        int[] referenceData = new int[]{};
        int[] inputData = new int[]{};
        quickSort.sort(inputData);
        assertArrayEquals(referenceData, inputData);
    }

    @Test
    public void verifiesOneElement() {
        int[] referenceData = new int[]{123321};
        int[] inputData = new int[]{123321};
        quickSort.sort(inputData);
        assertArrayEquals(referenceData, inputData);
    }

    @Test
    public void sorts() {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] inputData = new int[]{9, 1, 0, 2, 6, 7, 5, 3, 8, 4, 15, 12, 10, 11, 13, 14};
        quickSort.sort(inputData);
        assertArrayEquals(referenceData, inputData);
    }

}