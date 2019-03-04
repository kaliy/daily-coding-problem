package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SumInArrayTest {
    private SumInArray sumInArray = new SumInArray();

    @Test
    void returnsFalseForASingleElementArray() {
        int[] array = new int[] {6};
        assertThat(sumInArray.isThereASum(array, 6)).isFalse();
    }

    @Test
    void throwsExceptionIfArrayIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new SumInArray().isThereASum(null, 6)
        );
    }

    @Test
    void throwsExceptionIfArrayIsEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new SumInArray().isThereASum(new int[] {}, 6)
        );
    }

    @Test
    void calculatesSumInTwoElementsArray() {
        int[] array = new int[] {1, 2};
        assertThat(sumInArray.isThereASum(array, 3)).isTrue();
    }

    @Test
    void calculatesSumIfSumIsInTheEndOfArray() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        assertThat(sumInArray.isThereASum(array, 9)).isTrue();
    }

    @Test
    void calculatesSumIfSumIsInTheBeginningOfArray() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        assertThat(sumInArray.isThereASum(array, 3)).isTrue();
    }

    @Test
    void calculatesSumIfTwoSumNumbersAreInRandomOrderInArray() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertThat(sumInArray.isThereASum(array, 5)).isTrue();
    }

    @Test
    void returnsFalseIfThereIsNoSumInTheArray() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertThat(sumInArray.isThereASum(array, 100)).isFalse();
    }

    @Test
    void returnsFalseIfThereIsNoSumInAnArrayButThereIsAGivenNumber() {
        int[] array = new int[] {10, 20, 30, 40, 50};
        assertThat(sumInArray.isThereASum(array, 20)).isFalse();
    }

    @Test
    void calculatesSumInAHugeArray() {
        int[] array = new Random().ints(6660013).toArray();
        array[1000] = 10000000;
        array[500000] = 9999999;

        assertThat(sumInArray.isThereASum(array, 19999999)).isTrue();
    }
}
