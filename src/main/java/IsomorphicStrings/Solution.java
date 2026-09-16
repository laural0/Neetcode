package IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapAlphabet1 = new HashMap<>();
        Map<Character, Character> mapAlphabet2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            Character insert1 = mapAlphabet1.putIfAbsent(s.charAt(i), t.charAt(i));
            Character insert2 = mapAlphabet2.putIfAbsent(t.charAt(i), s.charAt(i));

            if(insert1 != null && insert1 != t.charAt(i)) return false;
            if(insert2 != null && insert2 != s.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
    }
}
