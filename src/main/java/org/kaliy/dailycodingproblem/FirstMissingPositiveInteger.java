package org.kaliy.dailycodingproblem;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 */
public class FirstMissingPositiveInteger {
    // The only way when first missing positive can be array.length+1 is when there are all number from 1 to n ([1, 2, 3, 4] => 5).
    // As we need to have linear time complexity and constant space complexity, we can't use sorting or create an additional array.
    // The only option is to change the array values in place. I'm iterating the array and trying to move the array elements to
    // corresponding indexes (2 => array[2-1]). Then I'm looking for the first element that's not in order.
    // The worst case is when we need to do all of the exchanges in the first go ([4, 1, 2, 3]) - it will make N exchanges.
    // After that there will be no exchanges at all so the complexity is still linear.
    // Sample trace for [2, 5, -1, 1, 3] array:
    // [2, 5, -1, 1, 3] => [2, 2, -1, 1, 3] => [2, 2, -1, 1, 5] => [2, 2, 3, 1, 5] => [1, 2, 3, 1, 5]
    public int findFirstMissingPositiveInteger(int[] array) {
        // 2 5 -1 1 3
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            while (isInRange(number, array) && array[number - 1] != number) {
                int toChange = array[number - 1];
                array[number - 1] = number;
                number = toChange;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    private boolean isInRange(int number, int[] array) {
        return number > 0 && number <= array.length;
    }
}
