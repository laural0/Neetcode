package TwoIntegerSumII;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // 2 3 5 6 7 8 9 11
        int[] result = new int[2];

        int startIndex = 0, endIndex = numbers.length-1;

        while (startIndex < endIndex) {
            if (numbers[startIndex] + numbers[endIndex] == target) {
                result[0] = startIndex + 1;
                result[1] = endIndex + 1;
                break;
            } else if (numbers[startIndex] + numbers[endIndex] > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return result;
    }
}
