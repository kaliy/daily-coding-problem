package org.kaliy.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UnivalTreeCounterTest {
    private UnivalTreeCounter univalTreeCounter = new UnivalTreeCounter();

    @ParameterizedTest(name = "{2}")
    @MethodSource("testCases")
    void countsUnivalTrees(Node<Integer> node, int expected, String caseName) {
        assertThat(univalTreeCounter.count(node)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(n(5), 1, "returns 1 for a single element node"),
                Arguments.of(
                        n(5, n(5), n(5)), 3, "counts univals of a tree with children"
                ),
                Arguments.of(
                        n(5, n(5, n(5), n(5)), n(5)), 5, "counts univals of a tree with grandchildren"
                ),
                Arguments.of(
                        n(5, n(5, n(5, n(5), null), null), null), 4, "counts univals of nodes with left only children"
                ),
                Arguments.of(
                        n(5, null, n(5, null, n(5, null, n(5)))), 4, "counts univals of nodes with right only children"
                ),
                Arguments.of(
                        n(0, n(1), n(0, n(1, n(1), n(1)), n(0))), 5, "counts univals in mixed subtrees"
                )
        );
    }

    private static Node<Integer> n(int val) {
        return new Node<>(val);
    }

    private static Node<Integer> n(int val, Node<Integer> left, Node<Integer> right) {
        return new Node<>(val, left, right);
    }
}
