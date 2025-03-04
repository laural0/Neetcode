package PermutationString;

// https://neetcode.io/problems/permutation-string

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] frequencyS1 = new int[26];
        int[] frequencyS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            frequencyS1[s1.charAt(i) - 'a']++;
            frequencyS2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (frequencyS1[i] == frequencyS2[i]) matches++;
        }

        int l=0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if(matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            frequencyS2[index]++;
            if(frequencyS2[index] == frequencyS1[index])
                matches++;
            else if(frequencyS2[index] - 1 == frequencyS1[index])
                matches--;

            index = s2.charAt(l) - 'a';
            frequencyS2[index]--;
            if(frequencyS2[index] == frequencyS1[index])
                matches++;
            else if(frequencyS2[index] + 1 == frequencyS1[index])
                matches--;
            l++;
        }

        return matches == 26;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("abc", "cccccbabbbaaaa"));
    }
}
