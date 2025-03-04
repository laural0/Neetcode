package DailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

// https://neetcode.io/problems/daily-temperatures

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stiva = new Stack<>();
        int[] result = new int[temperatures.length];

        stiva.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (!stiva.empty()) {
                if (temperatures[i] <= temperatures[stiva.peek()])
                    stiva.push(i);
                else {
                    while (!stiva.empty() && temperatures[i] > temperatures[stiva.peek()]){
                        int index = stiva.pop();
                        result[index] = i - index;

                    }
                    stiva.push(i);
                }
            } else {
                result[i] = 0;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28});
    }
}
