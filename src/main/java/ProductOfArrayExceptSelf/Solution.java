package ProductOfArrayExceptSelf;

// https://neetcode.io/problems/products-of-array-discluding-self

public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int helper = 1;
        int[] st = new int[nums.length];
        int[] dr = new int[nums.length];
        int sizeST = 0;
        int sizeDR = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                helper*=nums[i-1];
            }
            st[sizeST++] = helper;
        }
        helper = 1;
        for(int i = nums.length-1; i >= 0; i--){
            if(i < nums.length-1){
                helper*=nums[i+1];
            }
            dr[sizeDR++] = helper;
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = st[i] * dr[nums.length -1 - i];

        }

        return result;
    }
}
