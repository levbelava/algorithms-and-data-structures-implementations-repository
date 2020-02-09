package com.thebelava.algorepo.sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class BeadSortTest {
    private final BeadSort beadSort = new BeadSort();

    @Test
    public void verifiesNullInput() {
        assertNull(beadSort.sort(null));
    }

    @Test
    public void verifiesZeroElements() {
        int[] referenceData = new int[]{};
        int[] inputData = new int[]{};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void verifiesOneElement() {
        int[] referenceData = new int[]{123321};
        int[] inputData = new int[]{123321};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void sorts() {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] inputData = new int[]{9, 1, 0, 2, 6, 7, 5, 3, 8, 4};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

    @Test
    public void sortsBig() {
        int[] referenceData = new int[]{0, 25, 119, 586, 8547, 58964, 78596};
        int[] inputData = new int[]{586, 25, 58964, 8547, 119, 0, 78596};
        assertArrayEquals(referenceData, beadSort.sort(inputData));
    }

}