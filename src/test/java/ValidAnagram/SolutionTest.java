package ValidAnagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("racecar", "carrace", true),
                new TestCase("jar", "jam", false)
        );
    }

    private record TestCase(String inputS, String inputT, boolean outputResult) {

    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testValidAnagram(TestCase testCase) {
        Solution solution = new Solution();
        boolean result = solution.isAnagram(testCase.inputS, testCase.inputT);

        assertThat(result).isEqualTo(testCase.outputResult);
    }


}
