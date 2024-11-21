package TwoSum;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void onInit(){solution = new Solution();}

    @Test
    public void stream_case1(){

        int[] nums = {3, 4, 5, 6};
        int target = 7;

        var actualResult  = solution.twoSum(nums, target);
        int[] expectedResult = {0, 1};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void stream_case2(){

        int[] nums = {4,5,6};
        int target = 10;

        var actualResult  = solution.twoSum(nums, target);
        int[] expectedResult = {0, 2};

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void stream_case3(){

        int[] nums = {5, 5};
        int target = 10;

        var actualResult  = solution.twoSum(nums, target);
        int[] expectedResult = {0, 1};
        System.out.println(Arrays.toString(actualResult));

        assertArrayEquals(expectedResult, actualResult);
    }

}
