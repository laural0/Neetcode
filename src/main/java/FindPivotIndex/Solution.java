package FindPivotIndex;

public class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] sufixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = 0;
                sufixSum[nums.length - i - 1] = 0;
            } else {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
                sufixSum[nums.length - i - 1] = sufixSum[nums.length - i] + nums[nums.length - i];
            }
        }

        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sufixSum[i] == prefixSum[i]) {
                result = i;
                break;
            }
        }

        return result;
    }
}
