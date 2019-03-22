package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaliy.dailycodingproblem.ClassroomScheduler.Interval;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClassroomSchedulerTest {

    private ClassroomScheduler classroomScheduler = new ClassroomScheduler();

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void calculatesClassroomNumbers(Interval[] intervals, int expected, String caseName) {
        assertThat(classroomScheduler.calculateMinimumClassroomNumber(intervals)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new Interval[] {}, 0, "returns 0 for an empty array"),
                Arguments.of(new Interval[] {i(0, 666)}, 1, "returns 1 for a single element array"),
                Arguments.of(new Interval[] {i(0, 10), i(11, 20)}, 1, "return 1 for non-intersecting intervals"),
                Arguments.of(new Interval[] {i(30, 75), i(0, 50), i(60, 150)}, 2, "supports intersecting times"),
                Arguments.of(new Interval[] {i(10, 12), i(12, 14)}, 1, "equal start and end does not result to an intersection"),
                Arguments.of(new Interval[] {i(0, 50), i(0, 40), i(1000, 5000), i(10, 60), i(20, 70)}, 4, "supports multiple busy classrooms at the same time")
        );
    }

    private static Interval i(int start, int end) {
        return new Interval(start, end);
    }

}
