package org.kaliy.dailycodingproblem;

import java.util.Arrays;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 */
public class ClassroomScheduler {

    public int calculateMinimumClassroomNumber(Interval[] intervals) {
        assert null != intervals;
        int[] startTimes = Arrays.stream(intervals).mapToInt(i -> i.from).toArray();
        int[] endTimes = Arrays.stream(intervals).mapToInt(i -> i.to).toArray();
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int start = 0, end = 0, maxNumber = 0, currentNumber = 0;

        while (start < startTimes.length && end < endTimes.length) {
            if (startTimes[start] < endTimes[end]) {
                if (++currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                }
                start++;
            } else {
                currentNumber--;
                end++;
            }
        }
        return maxNumber;
    }

    public static class Interval implements Comparable<Interval> {
        private int from;
        private int to;

        public Interval(int from, int to) {
            assert from < to;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Interval i) {
            if (from == i.from) {
                return to - i.to;
            } else {
                return from - i.from;
            }
        }
    }
}
