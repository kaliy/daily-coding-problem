package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayMultiplicationTest {
    private ArrayMultiplication arrayMultiplication = new ArrayMultiplication();

    @Test
    void returnsInputArrayIfItIsEmpty() {
        assertThat(arrayMultiplication.multiply(new int[] {})).isEqualTo(new int[] {});
    }

    @Test
    void returnsInputArrayIfItContainsSingleElement() {
        assertThat(arrayMultiplication.multiply(new int[] {2})).isEqualTo(new int[] {2});
    }

    @Test
    void returnsInputArrayIfItContainsTwoElements() {
        assertThat(arrayMultiplication.multiply(new int[] {2, 4})).isEqualTo(new int[] {2, 4});
    }

    @Test
    void multipliesElementsInThreeElementArray() {
        assertThat(arrayMultiplication.multiply(new int[] {3, 2, 1})).isEqualTo(new int[] {2, 3, 6});
    }

    @Test
    void multipliesElementsInFiveElementArray() {
        assertThat(arrayMultiplication.multiply(new int[] {2, 3, 4, 5, 6})).isEqualTo(new int[] {360, 240, 180, 144, 120});
    }

    @Test
    void supportsArraysWithASingleZero() {
        assertThat(arrayMultiplication.multiply(new int[] {1, 2, 0, 4, 3})).isEqualTo(new int[] {0, 0, 24, 0, 0});
    }

    @Test
    void returnsArrayWithZeroesIfThereIsMoreThanZero() {
        assertThat(arrayMultiplication.multiply(new int[] {1, 0, 3, 0, 5})).isEqualTo(new int[] {0, 0, 0, 0, 0});
    }

    @Test
    void supportsArraysWithEvenNegativeNumbers() {
        assertThat(arrayMultiplication.multiply(new int[] {1, -2, 3, -4, 5})).isEqualTo(new int[] {120, -60, 40, -30, 24});
    }

    @Test
    void supportsArraysWithOddNegativeNumbers() {
        assertThat(arrayMultiplication.multiply(new int[] {1, -2, 3, 4, 5})).isEqualTo(new int[] {-120, 60, -40, -30, -24});
    }
}
