package ProductOfArrayExceptSelf;

// https://neetcode.io/problems/products-of-array-discluding-self

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        int helper = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) {
                helper *= nums[i + 1];
                result[i] = result[i] * helper;
            }
        }

        return result;
    }
}
