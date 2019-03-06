package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kaliy.dailycodingproblem.FunctionalPairs.car;
import static org.kaliy.dailycodingproblem.FunctionalPairs.cdr;
import static org.kaliy.dailycodingproblem.FunctionalPairs.cons;

class FunctionalPairsTest {
    @Test
    void carReturnsFirstElementOfPair() {
        assertThat(car(cons(3, 4))).isEqualTo(3);
    }

    @Test
    void cdrReturnsSecondElementOfPair() {
        assertThat(cdr(cons(3, 4))).isEqualTo(4);
    }
}
