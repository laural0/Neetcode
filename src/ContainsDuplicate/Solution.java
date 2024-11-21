package ContainsDuplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(nums.length);
        Arrays.stream(nums).forEach(value ->
                frequencyMap.put(value,
                        (frequencyMap.containsKey(value) ?
                                frequencyMap.get(value) + 1 :
                                0)
                ));

        if (frequencyMap.entrySet().size() == nums.length) return false;
        return true;
    }
}

