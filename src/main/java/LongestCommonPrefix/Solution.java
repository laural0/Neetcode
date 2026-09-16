package LongestCommonPrefix;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        String firstString = strs[0];

        for (String str : strs) {
            while (!str.substring(0, Math.min(firstString.length(), str.length())).equals(firstString)) {
                firstString = firstString.substring(0, firstString.length() - 1);
            }
        }

        return firstString;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }


}
