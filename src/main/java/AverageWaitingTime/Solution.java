package AverageWaitingTime;

//https://leetcode.com/problems/average-waiting-time

public class Solution {
    public double averageWaitingTime(int[][] customers) {

        double t0 = customers[0][0], ti, t1 = customers[0][1] + customers[0][0];
        double sum = t1 - customers[0][0];

        for (int i = 1; i < customers.length; i++) {
            t0 = customers[i][0];
            ti = t1;
            if (ti < t0) ti = t0;
            t1 = ti + customers[i][1];

            sum += t1 - t0;

        }

        return sum / customers.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
    }
}
