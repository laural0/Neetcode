package LongestConsecutiveSequence;

// https://neetcode.io/problems/longest-consecutive-sequence

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int j : nums) {
            numbers.add(j);
        }
        int maxLength = 0, length = 0;
        for (int num : nums) {
            if (!numbers.contains(num - 1)) {
                length++;
                while (numbers.contains(num + length)) length++;
                maxLength = Math.max(maxLength, length);
                length = 0;
            }

        }
        return maxLength;
    }
}
