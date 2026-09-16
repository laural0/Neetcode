package MinimumDifference;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minDif = nums[nums.length - 1] - nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 >= 0 && nums[i] - nums[i - k + 1] < minDif) {
                minDif = nums[i] - nums[i - k + 1];
            }
        }

        return minDif;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(new int[]{2, 5, 3, 1, 6, 3}, 3));
    }
}
