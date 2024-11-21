package TwoSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {
    // Define the record for test case data
    private record TestCase(int[] inputArray, int target, int[] outputArray) {
    }

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    // Specify the method to supply test data
    void testTwoSum(TestCase testCase) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(testCase.inputArray(), testCase.target());

        // Use AssertJ for better assertions
        assertThat(result).containsExactly(testCase.outputArray());
    }

    // MethodSource to provide test cases
    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),  // Test case 1
                new TestCase(new int[]{3, 2, 4}, 6, new int[]{1, 2}),       // test case 2
                new TestCase(new int[]{3, 2, 4}, 6, new int[]{1, 2}),       // Test case 3
                new TestCase(new int[]{3, 3}, 6, new int[]{0, 1})           // Test case 4
        );
    }

}
