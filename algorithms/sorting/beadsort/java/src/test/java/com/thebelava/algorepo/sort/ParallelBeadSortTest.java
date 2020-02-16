package com.thebelava.algorepo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParallelBeadSortTest {
    private final ParallelBeadSort beadSort = new ParallelBeadSort(64);

    @Test
    public void verifiesNullInput() throws InterruptedException {
        assertNull(beadSort.sort(null));
    }

    @Test
    public void verifiesZeroElements() throws InterruptedException {
        int[] referenceData = new int[]{};
        int[] inputData = new int[]{};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void verifiesOneElement() throws InterruptedException {
        int[] referenceData = new int[]{123321};
        int[] inputData = new int[]{123321};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void sorts() throws InterruptedException {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] inputData = new int[]{9, 1, 0, 2, 6, 7, 5, 3, 8, 4};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void sortsBig() throws InterruptedException {
        int[] referenceData = new int[]{0, 25, 119, 586, 8547, 58964, 78596};
        int[] inputData = new int[]{586, 25, 58964, 8547, 119, 0, 78596};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

}