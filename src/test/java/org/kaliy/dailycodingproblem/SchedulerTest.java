package org.kaliy.dailycodingproblem;

import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SchedulerTest {
    private Scheduler scheduler = new Scheduler();

    @Test
    void executesFunctionsWithDelay() {
        long start = System.currentTimeMillis();
        int[] array = new int[1];
        scheduler.schedule(() -> array[0] = 666, 1000);
        Awaitility.await().atMost(Duration.TEN_SECONDS).until(() -> array[0] == 666);
        assertThat(System.currentTimeMillis() - start).isGreaterThanOrEqualTo(1000);
    }

    @Test
    void throwsExceptionIfCalledWithNegativeDelay() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> scheduler.schedule(() -> {
                }, -666)
        );
    }
}
