package lib;

/**
 * Used to make timing tests of algorithms and display
 * the time difference.
 *
 * @author Cole Gartner
 * @version Oct 12, 2021
 */
public class TimingTest {
    
    private long start, stop;
    
    /**
     * Creates a new Timer object.
     */
    public TimingTest () { }
    
    /**
     * Starts the timer.
     */
    public void startTimer() {
        start = System.nanoTime();
        stop = 0;
    }
    
    /**
     * Stops the timer and returns the time elapsed
     * in nanoseconds.
     * @return time
     */
    public double stopTimer() {
        stop = System.nanoTime();
        return (stop - start);
    }
    
    /**
     * Get Start
     * @return start
     */
    public long getStart() { return start; }
    
    /**
     * Get Stop
     * @return stop
     */
    public long getStop() { return stop; }
    
}
