package TopKFrequentElements;

import java.util.*;

//https://en.wikipedia.org/wiki/Bucket_sort

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequency = new HashMap<>();

        for(Integer value : nums)
        {
            frequency.put(value, frequency.getOrDefault(value, 0) +1);
        }

        for(int i =0; i < bucket.length; i++)
            bucket[i] = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i>0; i--){
            for(int number : bucket[i]){
                result[index++] = number;
                if(index == k) return result;
            }
        }

        return result;
    }
}
