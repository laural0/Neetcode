package TopKFrequentElements;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://en.wikipedia.org/wiki/Bucket_sort

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> frequency = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue)));

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int size = 0;
        for (int i = bucket.length - 1; i > 0; i--) {
            for (int number : bucket[i]) {
                result[size++] = number;
                if (size == k) return result;
            }
        }
        return result;
    }
}
