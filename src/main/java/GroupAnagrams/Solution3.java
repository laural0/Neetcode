package GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        int[] arrayMap = new int[26];
        for (String str : strs) {
            for (int s : str.chars().toArray()) {
                arrayMap[s - 97]++;
            }

            String key = Arrays.toString(arrayMap);
            group.computeIfAbsent(key, s -> new ArrayList<>()).add(str);

            arrayMap = new int[26];
        }

        return group.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
