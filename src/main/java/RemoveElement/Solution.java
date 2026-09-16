package RemoveElement;

import java.util.Arrays;

public class Solution {

//    public int removeElement(int[] nums, int val) {
//        int k=0;
//
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] != val){
//                nums[k++] = nums[i];
//            }
//        }
//
//        return k;
//    }

    public int removeElement(int[] nums, int val) {
        int[] result = Arrays.stream(nums).filter(value -> value != val).toArray();
        System.arraycopy(result, 0, nums, 0, result.length);

        return result.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
