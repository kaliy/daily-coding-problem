package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackWithMaxTest {

    private StackWithMax<Integer> stack = new StackWithMax<>();

    @Test
    void returnsNullOnPoppingEmptyStack() {
        assertThat(stack.pop()).isNull();
    }

    @Test
    void pushesAndPopsSingleElement() {
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    void popsNullsAfterNoElementsAreAvailable() {
        stack.push(111);
        assertThat(stack.pop()).isNotNull();
        assertThat(stack.pop()).isNull();
    }

    @Test
    void popsItemsInLifoFashion() {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
    }

    @Test
    void returnsNullMaxForAnEmptyStack() {
        assertThat(stack.max()).isNull();
    }

    @Test
    void returnsMaxEvenIfLatestElementIsLessThanMax() {
        stack.push(4);
        stack.push(1);
        assertThat(stack.max()).isEqualTo(4);
    }

    @Test
    void changesMaxAfterPopping() {
        stack.push(1);
        stack.push(4);
        stack.pop();
        assertThat(stack.max()).isEqualTo(1);
    }

    @Test
    void tracksMaximumAcrossMultipleValues() {
        stack.push(4);
        stack.push(1);
        stack.push(2);
        assertThat(stack.max()).isEqualTo(4);
        stack.pop();
        assertThat(stack.max()).isEqualTo(4);
    }
}
