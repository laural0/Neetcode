package SortColors;

import java.util.Arrays;

public class Solution {
//    public void sortColors(int[] nums) {
//        int[] colors = new int[]{0, 0, 0};
//
//        Arrays.stream(nums).forEach(value -> colors[value]++);
//        int index = 0;
//        for (int color = 0; color < colors.length; color++) {
//            while (colors[color] > 0) {
//                nums[index++] = color;
//                colors[color]--;
//            }
//        }
//    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for (int num : nums) {
            switch (num) {
                case 0: {
                    red++;
                    break;
                }
                case 1: {
                    white++;
                    break;
                }
                case 2: {
                    blue++;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
