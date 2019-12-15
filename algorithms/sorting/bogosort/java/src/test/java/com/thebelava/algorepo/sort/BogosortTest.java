package com.thebelava.algorepo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BogosortTest {
    private final Bogosort bogosort = new Bogosort();

    @Test
    public void verifiesNullInput() {
        assertNull(bogosort.sort(null));
    }

    @Test
    public void verifiesZeroElements() {
        int[] referenceData = new int[]{};
        int[] inputData = new int[]{};
        assertArrayEquals(referenceData, bogosort.sort(inputData));
    }

    @Test
    public void verifiesOneElement() {
        int[] referenceData = new int[]{123321};
        int[] inputData = new int[]{123321};
        assertArrayEquals(referenceData, bogosort.sort(inputData));
    }

    @Test
    public void sorts() {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] inputData = new int[]{9, 1, 0, 2, 6, 7, 5, 3, 8, 4};
        assertArrayEquals(referenceData, bogosort.sort(inputData));
    }

}