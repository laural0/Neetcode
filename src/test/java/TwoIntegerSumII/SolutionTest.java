package TwoIntegerSumII;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    public static Stream<TestCase> getTestCases(){
        return Stream.of(
                new TestCase(new int[]{1, 2, 3, 4}, 3, new int[]{1, 2}),
                new TestCase(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }

    private record TestCase(int[] input, int target, int[] output){}

    @ParameterizedTest
    @MethodSource("getTestCases")
    void testTwoIntegerSumII(TestCase testCase){
        int[] result = new Solution().twoSum(testCase.input, testCase.target);

        Assertions.assertThat(result).containsExactly(testCase.output);
    }
}
