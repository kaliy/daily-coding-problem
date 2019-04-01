package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RunLengthEncoderTest {
    private RunLengthEncoder runLengthEncoder = new RunLengthEncoder();

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void encodesString(String original, String encoded, String caseName) {
        assertThat(runLengthEncoder.encode(original)).isEqualTo(encoded);
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void decodesString(String original, String encoded, String caseName) {
        assertThat(runLengthEncoder.decode(encoded)).isEqualTo(original);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("A", "1A", "processes single character string"),
                Arguments.of("AAAA", "4A", "supports repeated character in a string"),
                Arguments.of("Aa", "1A1a", "is case sensitive"),
                Arguments.of("AAAABBBCCDAA", "4A3B2C1D2A", "supports multiple character encoding")
        );
    }

}
