package com.seleniumtesting.dobiDemo.basicOperration;

public class sleep {

    /**
     * Causes the currently executing thread to sleep (temporarily cease
     *      execution) for the specified number of milliseconds, subject to
     *      the precision and accuracy of system timers and schedulers. The thread
     *      does not lose ownership of any monitors.
     *
     * @param Millis the length of time to sleep in milliseconds
     */
    public static void sleep(int Millis){
        try {
            Thread.sleep(Millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
