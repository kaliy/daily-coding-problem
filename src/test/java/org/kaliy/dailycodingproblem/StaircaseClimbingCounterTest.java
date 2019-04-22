package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StaircaseClimbingCounterTest {

    private StaircaseClimbingCounter staircaseClimbingCounter = new StaircaseClimbingCounter();

    @ParameterizedTest(name = "{3}")
    @MethodSource("testCases")
    void countsDecodingOptions(int steps, int[] ways, int expected, String caseName) {
        assertThat(staircaseClimbingCounter.count(steps, ways)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(7, new int[] {2, 4}, 0, "returns 0 if there is no way to climb the staircase"),
                        Arguments.of(6, new int[] {2, 4}, 3, "accept steps array not starting from 1"),
                        Arguments.of(8, new int[] {1, 3, 5}, 19, "accepts multiple elements in possible steps array")
                ),
                fibonacci()
        );
    }

    private static Stream<Arguments> fibonacci() {
        return Stream.iterate(new int[] {1, 2, 1}, p -> new int[] {p[1], p[0] + p[1], p[2] + 1})
                .limit(40)
                .map(p -> Arguments.of(p[2], new int[] {1, 2}, p[0], String.format("returns %d for %d steps where you can climb by 1 or 2 steps at a time", p[0], p[2])));
    }
}
