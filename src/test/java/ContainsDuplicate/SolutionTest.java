package ContainsDuplicate;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp(){ solution = new Solution(); }

    @Test
    public void stream_case1(){
        int[] nums = {1, 2, 3, 3};

        boolean actualResult = solution.hasDuplicate(nums);

        assertEquals(true, actualResult);
    }

    @Test
    public void stream_case2(){
        int[] nums = {1, 2, 3, 4};

        boolean actualResult = solution.hasDuplicate(nums);

        assertEquals(false, actualResult);
    }
}
