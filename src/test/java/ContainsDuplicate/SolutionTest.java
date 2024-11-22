package ContainsDuplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{1, 2, 3, 3}, true),
                new TestCase(new int[]{1, 2, 3, 4}, false)
        );
    }

    private record TestCase(int[] inputArray, boolean outputResult) {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testContainsDuplicate(TestCase testCase) {
        Solution solution = new Solution();
        boolean result = solution.hasDuplicate(testCase.inputArray);

        assertThat(result).isEqualTo(testCase.outputResult);
    }


}
