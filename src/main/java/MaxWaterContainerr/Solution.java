package MaxWaterContainerr;

class Solution {
    public int maxArea(int[] heights) {
        int startIndex = 0;
        int endIndex = heights.length - 1;

        int maxAmount = 0;
        while (startIndex < endIndex) {
            int volum = Math.min(heights[startIndex], heights[endIndex]) * (endIndex-startIndex);

            if (volum > maxAmount) maxAmount = volum;

            if (heights[startIndex] > heights[endIndex]) endIndex--;
            else startIndex++;
        }
        return maxAmount;
    }

    public static void main(String[] args) {
        int result = new Solution().maxArea(new int[]{1,7,2,5,12,3,500,500,7,8,4,7,3,6});
        System.out.println(result);
    }
}

