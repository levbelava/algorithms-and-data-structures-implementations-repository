public class PancakeSort {

    public int[] sort(int[] inputData) {
        if (isNothingToSort(inputData)) {
            return inputData;
        }
        return pancakeSort(inputData);
    }

    private int[] pancakeSort(int[] inputData) {
        for (int i = inputData.length; i > 1; i--) {
            flipPancakes(inputData, findPositionOfMaxValue(inputData, i));
            flipPancakes(inputData, i - 1);
        }
        return inputData;
    }

    public int findPositionOfMaxValue(int[] inputData, int highIndexPlusOne) {
        int maxValue = inputData[0];
        int maxValuePosition = 0;
        for (int i = 1; i < highIndexPlusOne; i++) {
            if (inputData[i] >= maxValue) {
                maxValue = inputData[i];
                maxValuePosition = i;
            }
        }
        return maxValuePosition;
    }

    public static void flipPancakes(int[] inputData, int highIndex) {
        int j = highIndex;
        for (int i = 0; i < highIndex; i++) {
            int temp = inputData[j];
            inputData[j] = inputData[i];
            inputData[i] = temp;
            j--;
        }
    }

    private boolean isNothingToSort(int[] inputData) {
        return inputData == null || inputData.length <= 1;
    }
}
