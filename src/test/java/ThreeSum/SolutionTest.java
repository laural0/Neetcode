package ThreeSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    // Define the record for test case data
    private record TestCase(int[] input, List<List<Integer>> output) {
    }

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testThreeSum(TestCase testCase) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(testCase.input);

        // Use AssertJ for better assertions
        assertThat(result).containsExactlyInAnyOrderElementsOf(testCase.output);
    }

    // MethodSource to provide test cases
    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{-1, 0, 1, 2, -1, -4}, List.of(
                        List.of(-1, -1, 2),
                        List.of(-1, 0, 1)
                )),
                new TestCase(new int[]{0, 1, 1}, List.of()),
                new TestCase(new int[]{0, 0, 0}, List.of(
                        List.of(0, 0, 0)
                )),
                new TestCase(new int[]{-2, 0, 1, 1, 2}, List.of(
                        List.of(-2, 0, 2),
                        List.of(-2, 1, 1)
                )),
                new TestCase(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, List.of(
                        List.of(-4, -2, 6),
                        List.of(-4, 0, 4),
                        List.of(-4, 1, 3),
                        List.of(-4, 2, 2),
                        List.of(-2, -2, 4),
                        List.of(-2, 0, 2)
                ))
        );
    }
}