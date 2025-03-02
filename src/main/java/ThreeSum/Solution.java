package ThreeSum;

import java.util.*;
import java.util.stream.Stream;

// https://neetcode.io/problems/three-integer-sum

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> inputArray = Arrays.stream(nums).sorted().boxed().toList();
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < inputArray.size(); i++) {
            int a = -inputArray.get(i);
            int b = i+1;
            int c = inputArray.size()-1;

            while(b<c){
                if(inputArray.get(b)+inputArray.get(c) > a) {
                    c--;
                }else if(inputArray.get(b) + inputArray.get(c) < a){
                    b++;
                } else{
                    result.add(Arrays.asList(-a, inputArray.get(b), inputArray.get(c)));
                    c--;
                }
            }
        }

        return result.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-2,0,1,1,2}));
    }
}
