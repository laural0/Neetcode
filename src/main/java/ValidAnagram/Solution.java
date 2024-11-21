package ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t){

        if(s.length() != t.length()) return false;

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char character : s.toCharArray()) {
            characterIntegerMap.put(character, characterIntegerMap.getOrDefault(character, 0) + 1);
        }
        for (char character : t.toCharArray()) {
            if (characterIntegerMap.containsKey(character)) {
                if (characterIntegerMap.get(character) > 1)
                    characterIntegerMap.replace(character, characterIntegerMap.get(character) - 1);
                else characterIntegerMap.remove(character);
            }
        }
        return !(characterIntegerMap.size() > 0);
    }
}
