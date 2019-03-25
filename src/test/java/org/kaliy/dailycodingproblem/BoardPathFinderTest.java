package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BoardPathFinderTest {

    @Test
    void findsAWayInASquareBoard() {
        boolean[][] board = new boolean[][] {
                new boolean[] {false, false, false, false},
                new boolean[] {true, true, false, true},
                new boolean[] {false, false, false, false},
                new boolean[] {false, false, false, false}
        };
        var solver = new BoardPathFinder(board);

        assertThat(solver.findPath(new Coordinate(3, 0), new Coordinate(0, 0))).hasValue(7);
    }

    @Test
    void findsAWayInARectangularBoard() {
        boolean[][] board = new boolean[][] {
                new boolean[] {false, false, false, false, false, false},
                new boolean[] {true, true, true, true, true, false},
                new boolean[] {true, false, false, false, true, false},
                new boolean[] {false, false, true, false, false, false}
        };
        var solver = new BoardPathFinder(board);

        assertThat(solver.findPath(new Coordinate(0, 0), new Coordinate(3, 0))).hasValue(15);
    }

    @Test
    void returns0IfFromAndToAreTheSame() {
        boolean[][] board = new boolean[][] {
                new boolean[] {false, false},
                new boolean[] {true, true}
        };
        var solver = new BoardPathFinder(board);

        assertThat(solver.findPath(new Coordinate(0, 0), new Coordinate(0, 0))).hasValue(0);
    }

    @Test
    void returnsEmptyIfThereIsNoPath() {
        boolean[][] board = new boolean[][] {
                new boolean[] {false, false, false, false},
                new boolean[] {true, true, true, true},
                new boolean[] {false, false, false, false},
                new boolean[] {false, false, false, false}
        };
        var solver = new BoardPathFinder(board);

        assertThat(solver.findPath(new Coordinate(3, 0), new Coordinate(0, 0))).isEmpty();
    }

    @Test
    void throwsExceptionIfFromHasValueTrue() {
        boolean[][] board = new boolean[][] {
                new boolean[] {false, false},
                new boolean[] {true, true}
        };
        var solver = new BoardPathFinder(board);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                solver.findPath(new Coordinate(1, 0), new Coordinate(0, 0))
        );
    }

    @Test
    void throwsExceptionOnNullBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new BoardPathFinder(null)
        );
    }

    @Test
    void throwsExceptionOnEmptyBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new BoardPathFinder(new boolean[][] {})
        );
    }

    @Test
    void throwsExceptionOnBoardWithNullRow() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new BoardPathFinder(new boolean[][] {null, null})
        );
    }

    @Test
    void throwsExceptionOnBoardWithEmptyRow() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new BoardPathFinder(new boolean[][] {new boolean[] {}, new boolean[] {}})
        );
    }

    @Test
    void throwsExceptionOnBoardWithInconsistentColumnCount() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new BoardPathFinder(new boolean[][] {new boolean[] {true, true, true}, new boolean[] {true, true}})
        );
    }
}
