package com.thebelava.algorepo.sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class ParallelBogosortTest {
    private final ParallelBogosort parallelBogosort = new ParallelBogosort();

    /**
     *This test is 10 times harder then similar sorting test in single thread Bogosort
     * however in average scenario it takes about the same amount of time thanks to multithreading execution
     */
    @Test
    public void sorts() throws InterruptedException {
        int[] referenceData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] inputData = new int[]{9, 1, 0, 2, 6, 7, 5, 3, 8, 4, 10};
        assertArrayEquals(referenceData, parallelBogosort.sort(inputData, 8));
     }

    @Test
    public void verifiesNullInput() throws InterruptedException {
        assertNull(parallelBogosort.sort(null, 8));
    }

    @Test
    public void verifiesZeroElements() throws InterruptedException {
        int[] referenceData = new int[]{};
        int[] inputData = new int[]{};
        assertArrayEquals(referenceData, parallelBogosort.sort(inputData, 8));
    }

    @Test
    public void verifiesOneElement() throws InterruptedException {
        int[] referenceData = new int[]{123321};
        int[] inputData = new int[]{123321};
        assertArrayEquals(referenceData, parallelBogosort.sort(inputData, 8));
    }

}