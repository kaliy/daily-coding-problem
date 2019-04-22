package org.kaliy.dailycodingproblem;

import java.util.Arrays;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
 */
public class StaircaseClimbingCounter {
    public int count(int steps, int[] possibleSteps) {
        int[] results = new int[steps];
        for (int i = 0; i < steps; i++) {
            int currentStep = i;
            results[i] = Arrays.stream(possibleSteps)
                    .map(step -> {
                        if (currentStep + 1 < step) {
                            return 0;
                        } else if (step == currentStep + 1) {
                            return 1;
                        } else {
                            return results[currentStep - step];
                        }
                    }).sum();
        }
        return results[steps - 1];
    }
}
