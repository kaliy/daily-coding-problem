package org.kaliy.dailycodingproblem;

public class ArrayMultiplication {
    public int[] multiply(int[] input) {
        if (input.length <= 2) {
            return input;
        }

        int[] output = new int[input.length];
        output[0] = 1;

        int accumulator = 1;
        for (int i = 0; i < input.length - 1; i++) {
            accumulator *= input[i];
            output[i + 1] = accumulator;
        }

        accumulator = 1;
        for (int i = input.length - 1; i > 0; i--) {
            accumulator *= input[i];
            output[i - 1] *= accumulator;
        }
        return output;
    }
}
