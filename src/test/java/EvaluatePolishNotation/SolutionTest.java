package EvaluateRPN;

import EvaluatePolishNotation.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    // Define the record for test case data
    private record TestCase(String[] tokens, int expected) {}

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testEvalRPN(TestCase testCase) {
        Solution solution = new Solution();
        int result = solution.evalRPN(testCase.tokens);

        assertThat(result).isEqualTo(testCase.expected);
    }

    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new String[]{"2", "1", "+", "3", "*"}, 9),  // (2 + 1) * 3 = 9
                new TestCase(new String[]{"4", "13", "5", "/", "+"}, 6), // 4 + (13 / 5) = 6
                new TestCase(new String[]{"10", "6", "9", "3", "/", "-", "*"}, 30), // 10 * (6 - (9 / 3)) = 30
                new TestCase(new String[]{"3", "11", "+", "5", "-"}, 9), // (3 + 11) - 5 = 9
                new TestCase(new String[]{"4", "2", "+", "3", "-"}, 3),  // (4 + 2) - 3 = 3
                new TestCase(new String[]{"10", "2", "+", "3", "*"}, 36), // (10 + 2) * 3 = 36
                new TestCase(new String[]{"5", "1", "2", "+", "4", "*", "+", "3", "-"}, 14) // 5 + ((1 + 2) * 4) - 3 = 14
        );
    }
}
