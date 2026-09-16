package Search2dMatrix;

public class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else right = mid;
        }
        if (target == nums[left])
            return left;
        else return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;

        int up = 0, down = matrix.length - 1;

        while (up < down) {
            int mid = (up + down) / 2;

            if (target == matrix[mid][0])
                return true;
            else if (target > matrix[mid][0] && target > matrix[mid][matrix[mid].length - 1]) {
                up = mid + 1;
            } else down = mid;
        }

        if (target > matrix[up][matrix[0].length - 1])
            return false;
        else {
            int[] row = matrix[up];
            int left = 0, right = row.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (target == row[mid]) {
                    return true;
                } else if (target > row[mid]) {
                    left = mid + 1;
                } else right = mid-1;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.searchMatrix(
                new int[][]{
                        {1, 2, 4, 8},
                        {10, 11, 12, 13},
                        {14, 20, 30, 40}
                },
                41
        ));
    }
}
