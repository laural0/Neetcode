package MajorityElement2;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>(2);

        for (int num : nums) {
            if (result.containsKey(num)) {
                result.computeIfPresent(num, (integer, integer2) -> integer2 + 1);
            } else if (result.size() < 2) {
                result.put(num, 1);
            } else {
                result.entrySet().forEach(integerIntegerEntry -> integerIntegerEntry.setValue(integerIntegerEntry.getValue() - 1));
                result.entrySet().removeIf(integerIntegerEntry -> integerIntegerEntry.getValue() == 0);
            }
        }

        result.replaceAll((integer, integer2) -> 0);
        Arrays.stream(nums).forEach(value -> result.computeIfPresent(value, (integer, integer2) -> integer2 + 1));
        return result.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() > nums.length / 3).map(Map.Entry::getKey).toList();
    }
}
