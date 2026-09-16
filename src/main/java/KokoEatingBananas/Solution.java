package KokoEatingBananas;

import java.util.Arrays;
import java.util.List;

// https://neetcode.io/problems/eating-bananas?list=neetcode150
public class Solution {
    public boolean canEatBanana(int[] piles, int rate, int timeLimit) {
        long sum = 0;
        for (int pile : piles) {
            sum += pile / rate + (pile % rate == 0 ? 0 : 1);
            if (sum > timeLimit)
                return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        if (h == piles.length) return max;

        int left = 1, right = max, response = max;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatBanana(piles, mid, h)) {
                response = Math.min(response, mid);
                right = mid;
            } else left++;
        }

        return response;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
