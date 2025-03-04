package DailyTemperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    // Define the record for test case data
    private record TestCase(int[] temperatures, int[] expected) {}

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testDailyTemperatures(TestCase testCase) {
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(testCase.temperatures);

        // Use AssertJ for better assertions
        assertThat(result).containsExactly(testCase.expected);
    }

    // MethodSource to provide test cases
    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                new TestCase(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                new TestCase(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
                new TestCase(new int[]{90, 80, 70, 60}, new int[]{0, 0, 0, 0}), // No warmer days
                new TestCase(new int[]{50, 50, 50, 50}, new int[]{0, 0, 0, 0}), // Constant temperatures
                new TestCase(new int[]{80, 81, 80, 79, 78, 77, 76, 75, 74, 80}, new int[]{1, 0, 0, 6, 5, 4, 3, 2, 1, 0})
        );
    }
}