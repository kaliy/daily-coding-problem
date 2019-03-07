package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstMissingPositiveIntegerTest {
    private FirstMissingPositiveInteger firstMissingPositiveInteger = new FirstMissingPositiveInteger();

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void findsFirstMissingPositiveInteger(int[] input, int expected, String caseName) {
        assertThat(firstMissingPositiveInteger.findFirstMissingPositiveInteger(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        var largeList = new ArrayList<Integer>(6_666_013);
        for (int i = 1; i <= 6_666_013; i++) {
            largeList.add(i);
        }
        Collections.shuffle(largeList);
        var largeArray = largeList.stream().mapToInt(i -> i).toArray();

        return Stream.of(
                Arguments.of(new int[] {-1, -2, -3, -4}, 1, "returns 1 if all integers are negative"),
                Arguments.of(new int[] {}, 1, "returns 1 for an empty array"),
                Arguments.of(new int[] {1}, 2, "returns 2 for a single element array [1]"),
                Arguments.of(new int[] {666}, 1, "returns 1 for a single element array with an element other than 1"),
                Arguments.of(new int[] {4, 3, 2, 1}, 5, "returns first missing integer for a decrementing array"),
                Arguments.of(new int[] {1, 2, 3, 4}, 5, "returns first missing integer for an incrementing array"),
                Arguments.of(new int[] {2, 5, -1, 1, 3}, 4, "returns first missing integer for an array with negative numbers"),
                Arguments.of(new int[] {3, 4, 0, 1}, 2, "returns first missing integer for an array with zeros"),
                Arguments.of(new int[] {4, 2, 2, 1}, 3, "returns first missing integer for an array with repeated elements"),
                Arguments.of(largeArray, 6_666_014, "returns first missing integer for a large array")
        );
    }
}
