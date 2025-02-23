package EncodeAndDecodeStrings;

import EncodeAndDecodeStrings.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(Arrays.asList("neet","code","love","you")),
                new TestCase(Arrays.asList("we","say",":","yes"))
        );
    }

    private record TestCase(List<String> inputArray) {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testContainsDuplicate(TestCase testCase) {
        EncodeAndDecodeStrings.Solution solution = new Solution();
        String encoded = solution.encode(testCase.inputArray);
        List<String> decoded = solution.decode(encoded);

        assertThat(decoded).hasSameElementsAs(testCase.inputArray);
    }


}

