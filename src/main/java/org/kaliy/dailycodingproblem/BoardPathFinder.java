package org.kaliy.dailycodingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Given MxN matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach
 * the end coordinate from the start. If there is no possible path, then return null. You can move up,
 * left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
 */
public class BoardPathFinder {
    private final boolean[][] board;
    private final int rows;
    private final int columns;

    public BoardPathFinder(boolean[][] board) {
        validate(board);
        this.board = board;
        this.rows = board.length;
        this.columns = board[0].length;
    }

    public Optional<Integer> findPath(Coordinate from, Coordinate to) {
        if (board[from.getRow()][from.getColumn()]) {
            throw new IllegalArgumentException("Unreachable from coordinate");
        }
        if (from.equals(to)) {
            return Optional.of(0);
        }
        int currentTurn = 1;
        var visitedTiles = createNewTurnsMatrix();
        List<Coordinate> coordinatesToVisit = Collections.singletonList(from);
        visitedTiles[from.getRow()][from.getColumn()] = true;
        while (!coordinatesToVisit.isEmpty()) {
            List<Coordinate> newCoordinates = new ArrayList<>(coordinatesToVisit.size() * 4);
            for (Coordinate coordinate : coordinatesToVisit) {
                if (populateWithPossibleMoves(coordinate, newCoordinates, visitedTiles, to)) {
                    return Optional.of(currentTurn);
                }
            }
            currentTurn++;
            coordinatesToVisit = newCoordinates;
        }
        return Optional.empty();
    }

    private boolean populateWithPossibleMoves(Coordinate coordinate, List<Coordinate> coordinates, boolean[][] visited, Coordinate to) {
        return addCoordinate(new Coordinate(coordinate.getRow() - 1, coordinate.getColumn()), coordinates, visited, to)
               ||
               addCoordinate(new Coordinate(coordinate.getRow() + 1, coordinate.getColumn()), coordinates, visited, to)
               ||
               addCoordinate(new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1), coordinates, visited, to)
               ||
               addCoordinate(new Coordinate(coordinate.getRow(), coordinate.getColumn() - 1), coordinates, visited, to);
    }

    private boolean addCoordinate(Coordinate coordinate, List<Coordinate> coordinates, boolean[][] visited, Coordinate to) {
        if (coordinate.equals(to)) {
            return true;
        } else if (coordinate.getRow() < 0 ||
                   coordinate.getColumn() < 0 ||
                   coordinate.getRow() > rows - 1 ||
                   coordinate.getColumn() > columns - 1 ||
                   board[coordinate.getRow()][coordinate.getColumn()] ||
                   visited[coordinate.getRow()][coordinate.getColumn()]) {
            return false;
        } else {
            coordinates.add(coordinate);
            visited[coordinate.getRow()][coordinate.getColumn()] = true;
        }
        return false;
    }

    private boolean[][] createNewTurnsMatrix() {
        return new boolean[board.length][board[0].length];
    }

    private void validate(boolean[][] board) {
        if (null == board || board.length == 0) {
            throw new IllegalArgumentException("Board must not be empty");
        }
        for (boolean[] row : board) {
            if (null == row || row.length == 0) {
                throw new IllegalArgumentException("row must not be empty");
            }
        }
        int columns = board[0].length;
        for (boolean[] row : board) {
            if (row.length != columns) {
                throw new IllegalArgumentException("board must have the same number of columns in every row");
            }
        }
    }
}
