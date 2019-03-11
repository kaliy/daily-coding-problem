package org.kaliy.dailycodingproblem;

/**
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
public class Scheduler {
    //    The proper solution is to use the existing java functionality. I assume that's not the intention of this task
//    and you need to quickly code a simple method that will execute code after some time.
//    Here is a solution with ScheduledExecutorService:
//    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//    public void schedule(Runnable function, int ms) {
//        scheduledExecutorService.schedule(function, ms, TimeUnit.MILLISECONDS);
//    }
    public void schedule(Runnable function, int ms) {
        if (ms < 0) {
            throw new IllegalArgumentException();
        }
        new Thread(() -> {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                System.err.println("Interrupted, executing function right away");
            }
            function.run();
        }).start();
//        This is an ugly way to implement the scheduler but on a real interview that's the only way to do this
//        I think the purpose of this task is to discuss the way how would a candidate implement it rather than actually
//        implementing the scheduler. I would implement it based on a priority queue and polling for new records
//        and then executing in a separate thread pool.
    }
}
