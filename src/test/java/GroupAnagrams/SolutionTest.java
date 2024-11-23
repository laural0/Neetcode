package GroupAnagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    public static Stream<TestCase> provideTestCases() {
        return Stream.of(
                // Basic test case with a mix of anagrams
                new TestCase(
                        new String[]{"act", "pots", "tops", "cat", "stop", "hat"},
                        new ArrayList<>() {{
                            add(List.of("hat"));
                            add(List.of("act", "cat"));
                            add(List.of("stop", "pots", "tops"));
                        }}
                ),
                // Test case with empty input
                new TestCase(
                        new String[]{},
                        new ArrayList<>()
                ),
                // Test case with single word
                new TestCase(
                        new String[]{"hello"},
                        new ArrayList<>() {{
                            add(List.of("hello"));
                        }}
                ),
                // Test case with no anagrams
                new TestCase(
                        new String[]{"dog", "cat", "bird"},
                        new ArrayList<>() {{
                            add(List.of("dog"));
                            add(List.of("cat"));
                            add(List.of("bird"));
                        }}
                ),
                // Test case with multiple identical words
                new TestCase(
                        new String[]{"eat", "tea", "ate", "tea"},
                        new ArrayList<>() {{
                            add(List.of("eat", "tea", "ate", "tea"));
                        }}
                ),
                // Test case with anagrams and non-anagrams
                new TestCase(
                        new String[]{"listen", "silent", "enlist", "google", "goggle"},
                        new ArrayList<>() {{
                            add(List.of("listen", "silent", "enlist"));
                            add(List.of("google"));
                            add(List.of("goggle"));
                        }}
                )
        );
    }


    private record TestCase(String[] inputArray, List<List<String>> outputResult) {
    }

    private List<List<String>> normalizeList(List<List<String>> list){
        return list.stream().map(innerList -> innerList.stream().sorted().toList())
                .sorted(Comparator.comparing(a -> a.get(0)))
                .toList();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testContainsDuplicate(TestCase testCase) {
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(testCase.inputArray);

        assertThat(normalizeList(result))
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(normalizeList(testCase.outputResult));
    }


}
