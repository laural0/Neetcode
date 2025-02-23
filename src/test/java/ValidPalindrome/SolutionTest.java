package ValidPalindrome;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("Was it a car or a cat I saw?", true),
                new TestCase("tab a cat", false)
        );
    }

    private record TestCase(String input, boolean output) {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testValidPalindrome(TestCase testCase) {
        boolean result = new Solution().isPalindrome(testCase.input);

        Assertions.assertThat(result).isEqualTo(testCase.output);
    }
}
