package org.kaliy.dailycodingproblem;

import java.util.Arrays;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class SumInArray {

    public boolean isThereASum(int[] array, int number) {
        if (null == array || array.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int sum = array[left] + array[right];
            if (sum == number) {
                return true;
            } else if (sum > number) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
