package com.thebelava.algorepo.sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BitonicSortTest {
    private final BitonicSort bitonicSort = new BitonicSort();

    @Test
    public void handlesNullInput() {
        bitonicSort.sort(null);
    }

    @Test
    public void verifiesZeroElements() {
        bitonicSort.sort(new int[]{});
    }

    @Test
    public void verifiesNonPowerOfTwoNumberOfElementsToSort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bitonicSort.sort(new int[]{1, 2, 3}));
        assertTrue(exception.getMessage().contains("Sorts only arrays with a number of elements that a power of 2!"));
    }

    @Test
    public void sors() {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] inputData = new int[]{9, 11, 1, 13, 0, 2, 10, 6, 7, 15, 5, 3, 12, 8, 4, 14};
        bitonicSort.sort(inputData);
        assertArrayEquals(referenceData, inputData);
    }

}