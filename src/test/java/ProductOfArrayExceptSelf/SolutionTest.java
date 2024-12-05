package ProductOfArrayExceptSelf;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public record TestCase(int[] inputArray, int[] outputArray) {
    }

    private static Stream<TestCase> getTestCases() {
        return Stream.of(
                // Test with positive numbers
                new TestCase(new int[]{1, 2, 4, 6}, new int[]{48, 24, 12, 8}),
                // Test with single element array
                new TestCase(new int[]{10}, new int[]{1}),
                // Test with all ones
                new TestCase(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                // Test with zeros in the array
                new TestCase(new int[]{0, 4, 2, 0}, new int[]{0, 0, 0, 0}),
                new TestCase(new int[]{0, 4, 2, 3}, new int[]{24, 0, 0, 0}),
                // Test with negative numbers
                new TestCase(new int[]{-1, -2, -3, -4}, new int[]{-24, -12, -8, -6}),
                new TestCase(new int[]{-1, 2, -3, 4}, new int[]{-24, 12, -8, 6}),
                // Test with a mix of zeros and negative numbers
                new TestCase(new int[]{0, -2, -3, 0}, new int[]{0, 0, 0, 0}),
                // Test with larger arrays
                new TestCase(new int[]{1, 2, 3, 4, 5}, new int[]{120, 60, 40, 30, 24}),
                new TestCase(new int[]{1, 0, 3, 4, 5}, new int[]{0, 60, 0, 0, 0}),
                // Test with duplicate numbers
                new TestCase(new int[]{2, 2, 2, 2}, new int[]{8, 8, 8, 8}),
                // Test with array of size 2
                new TestCase(new int[]{1, 2}, new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    public void testProductOfArrayExceptSelf(TestCase testCase) {

        int[] result = new Solution().productExceptSelf(testCase.inputArray);

        assertThat(result).containsExactly(testCase.outputArray);
    }
}
