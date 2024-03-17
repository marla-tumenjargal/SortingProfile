/**
 * utility class used to measure the timeo f an algorithm, provides methods to start, stop, reset, and calculate time between start and stop events
 */
public class Stopwatch {
    private double startTime;
    private double stopTime;
    private boolean running;

    /**
     * starts time
     */
    public void start() {
        if (!running) {
            startTime = System.nanoTime();
            running = true;
        }
    }

    /**
     * stops time
     */
    public void stop() {
        if (running) {
            stopTime = System.nanoTime();
            running = false;
        }
    }

    /**
     * calculates the total amount of time past from start to stop
     * @return elapsed time (stopTime - startTime)
     */
    public double elapsedTime() {
        if (running) {
            return System.nanoTime() - startTime;
        } else {
            return stopTime - startTime;
        }
    }

    /**
     * resets all instance vars to 0
     */
    public void reset() {
        startTime = 0;
        stopTime = 0;
        running = false;
    }
}

