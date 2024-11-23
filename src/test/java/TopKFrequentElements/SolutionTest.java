package TopKFrequentElements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                // Basic test case with frequencies
                new TestCase(new int[]{1, 2, 2, 3, 3, 3}, 2, new int[]{2, 3}),
                // Test case where k equals the number of unique elements
                new TestCase(new int[]{4, 4, 4, 6, 6, 7, 7, 8}, 4, new int[]{4, 6, 7, 8}),
                // Test case with one element, k = 1
                new TestCase(new int[]{5}, 1, new int[]{5}),
                // Test case where input array has duplicates but k = 1
                new TestCase(new int[]{9, 9, 9, 10, 10, 11, 11, 11, 11}, 1, new int[]{11}),
                // Edge case: empty input array
                new TestCase(new int[]{}, 0, new int[]{}),
                // Edge case: single element repeated many times
                new TestCase(new int[]{7, 7, 7, 7, 7}, 1, new int[]{7}),
                // Edge case: more frequent elements than k
                new TestCase(new int[]{1, 1, 1, 2, 2, 3}, 1, new int[]{1}),
                // Test case with negatives and positives
                new TestCase(new int[]{-1, -1, -2, -2, -2, 3, 3, 3}, 2, new int[]{-2, 3})
                );
    }

    private record TestCase(int[] inputArray, int k, int[] outputArray){}

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testTopKFrequentElements(TestCase testCase){
        Solution solution = new Solution();
        int[] result = solution.topKFrequent(testCase.inputArray, testCase.k);

        assertThat(result)
                .as(String.format("\nExpected result: %s \nActual result: %s",
                        Arrays.toString(testCase.outputArray),
                        Arrays.toString(result)))
                .containsExactlyInAnyOrder(testCase.outputArray);
    }

}
