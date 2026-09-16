package MajorityElement;

public class Solution {
    public int majorityElement(int[] nums) {
        int contor = 0;
        int candidate = -1;

        for (int num : nums) {
            if (contor == 0) {
                candidate = num;
                contor = 1;
            } else if (num == candidate) {
                contor++;
            } else {
                contor--;
            }
        }

        return candidate;
    }
}
