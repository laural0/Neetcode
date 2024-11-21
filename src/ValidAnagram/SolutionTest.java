package ValidAnagram;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp(){ solution = new Solution(); }

    @Test
    public void stream_isAnagram(){
        String inputS = "racecar";
        String inputT = "carrace";

        boolean actualResult = solution.isAnagram(inputS, inputT);

        assertEquals(true, actualResult);
    }

    @Test
    public void stream_noAnagram(){
        String inputS = "jar";
        String inputT = "jam";

        boolean actualResult = solution.isAnagram(inputS, inputT);

        assertEquals(false, actualResult);
    }

    @Test
    public void stream_noAnagram2(){
        String inputS = "a";
        String inputT = "ab";

        boolean actualResult = solution.isAnagram(inputS, inputT);

        assertEquals(false, actualResult);
    }
}
