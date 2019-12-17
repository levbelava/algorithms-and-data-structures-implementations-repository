package com.thebelava.algorepo.sort;


import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;


public class ParallelBogosort {
    volatile boolean sortingIsDone = false;

    public int[] sort(final int[] inputData, int numberOfThreads) throws InterruptedException {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        final LinkedBlockingQueue<int[]> resultHolderQueue = new LinkedBlockingQueue<int[]>();
        final CountDownLatch resultIsReadyLatch = new CountDownLatch(1);
        for (int i = 0; i < numberOfThreads; i++) {
            createBogosortWorker(inputData, resultHolderQueue, resultIsReadyLatch).start();
        }
        resultIsReadyLatch.await();
        return resultHolderQueue.take();
    }

    private Thread createBogosortWorker(final int[] inputData, final LinkedBlockingQueue<int[]> resultQueue, final CountDownLatch resultReadyLatch) {
        return new Thread(new Runnable() {
            public void run() {
                Random random = new Random();
                int[] dataCopy = createInputDataCopy();
                while (isNotSorted(dataCopy)) {
                    if (sortingIsDone) {
                        return;
                    }
                    shuffleRandomly(dataCopy, random);
                }
                resultQueue.add(dataCopy);
                resultReadyLatch.countDown();
                sortingIsDone = true;
            }

            private int[] createInputDataCopy() {
                int[] dataCopy = new int[inputData.length];
                System.arraycopy(inputData, 0, dataCopy, 0, inputData.length);
                return dataCopy;
            }
        });
    }

    private boolean isNotSorted(int[] inputData) {
        for (int i = 0; i < inputData.length - 1; i++) {
            if (inputData[i] > inputData[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private void shuffleRandomly(int[] inputData, Random random) {
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
