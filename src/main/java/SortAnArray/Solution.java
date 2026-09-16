package SortAnArray;

import java.util.Arrays;

public class Solution {
    public int[] merge(int[] left, int[] right){
        int i = 0, j = 0, index=0;
        int[] result = new int[left.length + right.length];

        while(i < left.length && j < right.length){
            if(left[i] < right[j]) {
                result[index++] = left[i];
                i++;
            }else{
                result[index++] = right[j];
                j++;
            }
        }

        while(i < left.length){
            result[index++] = left[i++];
        }

        while(j < right.length){
            result[index++] = right[j++];
        }

        return result;
    }

    public int[] mergeSort(int[] nums){
        if(nums.length == 1) return nums;

        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return merge(left, right);
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }
}
