package org.kaliy.dailycodingproblem;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
 */
public class PiCalculation {

    public static final int ITERATIONS = 50000000;

    public double calculatePi() {
        final var inside = new AtomicInteger(0);
        IntStream.range(0, ITERATIONS).parallel().forEach(i -> {
            var random = ThreadLocalRandom.current();
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                inside.incrementAndGet();
            }
        });
        return ((double) inside.intValue() / ITERATIONS) * 4;
    }
}
