package BuyAndSellCrypto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[]{7,1,5,3,6,4}, 5),
                new TestCase(new int[]{7,6,4,3,1}, 0),
                new TestCase(new int[]{1,2,4,2,5,7,2,4,9,0,9}, 9)
        );
    }

    private record TestCase(int[] inputArray, int outputResult) {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testContainsDuplicate(TestCase testCase) {
        BuyAndSellCrypto.Solution solution = new Solution();
        int result = solution.maxProfit(testCase.inputArray);

        assertThat(result).isEqualTo(testCase.outputResult);
    }


}
