package MaxWaterContainerr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{1,7,2,5,4,7,3,6}, 36),
                new TestCase(new int[]{2,2,2}, 4)
        );
    }

    private record TestCase(int[] inputArray, int outputResult) {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testContainsDuplicate(TestCase testCase) {
        MaxWaterContainerr.Solution solution = new Solution();
        int result = solution.maxArea(testCase.inputArray);

        assertThat(result).isEqualTo(testCase.outputResult);
    }


}
