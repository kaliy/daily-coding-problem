package org.kaliy.dailycodingproblem;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PiCalculationTest {
    private PiCalculation piCalculation = new PiCalculation();

    @Test
    void calculatesPi() {
        assertThat(piCalculation.calculatePi()).isCloseTo(3.141593, Offset.offset(0.001));
    }
}
