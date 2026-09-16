package MonotonicArray;

//https://leetcode.com/problems/monotonic-array

public class Solution {
    public boolean isMonotonic(int[] nums) {
        int res = 0, counter = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) res += 1;
            else if (nums[i + 1] < nums[i]) res -= 1;
            else counter++;
        }

        return (res > 0 && res == nums.length - 1 - counter) || (res < 0 && res == -nums.length + 1 + counter)
               || (res == 0 && counter == nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[]{1, 3, 2}));
    }
}
