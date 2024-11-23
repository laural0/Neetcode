package GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private long noOfOccurences(String input, Integer character) {
        return input.chars().filter(value -> value == character).count();
    }

    private String streamTask(String input) {

        return input
                .chars()
                .boxed()
                .sorted()
                .distinct()
                .map(letter ->
                        new StringBuilder()
                                .append(Character.toString(letter))
                                .append(noOfOccurences(input, letter)))
                .collect(Collectors.joining());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> solution = new HashMap<>();
        List<String> words = Arrays.stream(strs).toList();

        var wordsTransformed = words.stream().map(this::streamTask).toList();

        System.out.println(wordsTransformed);
        for (int i = 0; i < words.size();i++) {
            if (!solution.containsKey(wordsTransformed.get(i))) {
                solution.put(wordsTransformed.get(i), new ArrayList<>());
            }
            solution.get(wordsTransformed.get(i)).add(words.get(i));
        }
        return solution.values().stream().toList();
    }

}
