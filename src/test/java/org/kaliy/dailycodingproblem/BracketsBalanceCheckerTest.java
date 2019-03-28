package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BracketsBalanceCheckerTest {

    private BracketsBalanceChecker bracketsBalanceChecker = new BracketsBalanceChecker();

    @Test
    void throwsExceptionOnEmptyString() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> bracketsBalanceChecker.isBalanced("")
        );
    }

    @Test
    void throwsExceptionOnNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> bracketsBalanceChecker.isBalanced(null)
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void checksIfBracketsAreBalanced(String input, boolean expected, String caseName) {
        assertThat(bracketsBalanceChecker.isBalanced(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("((()))", true, "supports ( and )"),
                Arguments.of("{{{}}}", true, "supports { and }"),
                Arguments.of("[[[]]]", true, "supports [ and ]"),
                Arguments.of("([])[]({})", true, "supports multiple brackets types in the same string"),
                Arguments.of("mish(krodetsa)[source?]({code})", true, "supports strings with characters other than brackets"),
                Arguments.of("i like to move it, move it", true, "returns true for a string with no brackets"),
                Arguments.of(")(", false, "detects inconsistency for ) and ("),
                Arguments.of("}{", false, "detects inconsistency for ] and ["),
                Arguments.of("][", false, "detects inconsistency for } and {"),
                Arguments.of("([)]", false, "detects inconsistency for a string with different types of brackets"),
                Arguments.of("((()", false, "detects inconsistency for uneven number of brackets")
        );
    }

}
