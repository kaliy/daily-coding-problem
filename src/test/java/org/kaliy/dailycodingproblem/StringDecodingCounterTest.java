package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringDecodingCounterTest {
    private StringDecodingCounter stringDecodingCounter = new StringDecodingCounter();

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void countsDecodingOptions(String string, int expected, String caseName) {
        assertThat(stringDecodingCounter.count(string)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
//        return fibonacci();
        return Stream.concat(
                Stream.of(
                        Arguments.of(null, 0, "returns 0 for a null string"),
                        Arguments.of("", 0, "returns 0 for an empty string"),
                        Arguments.of("12611", 6, "supports last letter (z=26)"),
                        Arguments.of("127271", 2, "doesn't merge symbols higher than 26")
                ),
                fibonacci());
    }

    private static Stream<Arguments> fibonacci() {
        StringBuilder sb = new StringBuilder();
        return Stream.iterate(new int[] {1, 2, 1}, p -> new int[] {p[1], p[0] + p[1], p[2] + 1})
                .limit(40)
                .map(p -> Arguments.of(sb.append("1").toString(), p[0], String.format("returns %d for %d same elements that can be merged into a new symbol (fibonacci)", p[0], p[2])));
    }

}
