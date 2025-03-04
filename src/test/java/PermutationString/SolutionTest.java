package PermutationString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    // Define the record for test case data
    private record TestCase(String s1, String s2, boolean output) {
    }

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCheckInclusion(TestCase testCase) {
        Solution solution = new Solution();
        boolean result = solution.checkInclusion(testCase.s1, testCase.s2);

        // Use AssertJ for better assertions
        assertThat(result).isEqualTo(testCase.output);
    }

    // MethodSource to provide test cases
    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("ab", "eidbaooo", true),  // "ba" is a permutation of "ab"
                new TestCase("ab", "eidboaoo", false), // No permutation of "ab" in s2
                new TestCase("abc", "cbaebabacd", true), // "cba" is a permutation of "abc"
                new TestCase("hello", "ooolleoooleh", false), // No permutation match
                new TestCase("adc", "dcda", true), // "dca" or "cda" are valid
                new TestCase("a", "a", true), // Single character match
                new TestCase("abc", "defghi", false), // No matching characters
                new TestCase("abc", "beacbabacd", true),
                new TestCase("abc", "bbbca", true)
        );
    }
}
