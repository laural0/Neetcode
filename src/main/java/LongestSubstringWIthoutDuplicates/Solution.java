package LongestSubstringWIthoutDuplicates;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> characterAndPosition = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (characterAndPosition.containsKey(s.charAt(i))) {
                i = characterAndPosition.get(s.charAt(i));
                characterAndPosition.clear();
            } else {
                characterAndPosition.put(s.charAt(i), i);
            }
            maxLength = Math.max(maxLength, characterAndPosition.size());
        }
        return maxLength;
    }
}
