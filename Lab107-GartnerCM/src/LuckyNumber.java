
import java.util.Random;

/**
 * Holds a lucky number with a name attached
 *
 * @author Cole Gartner
 * @version Oct 18, 2021
 */
public class LuckyNumber {
    
    private String name;
    private int luckyNumber;
    
    /**
     * Constructor for LuckyNumber
     * @param n name
     */
    public LuckyNumber (String n) {
        name = n;
        luckyNumber = new Random().nextInt(10);
    }
    
    /**
     * return name
     * @return name
     */
    public String getName() { return name; }
    
    /**
     * return number
     * @return lucky number
     */
    public int getNumber() { return luckyNumber; }
    
    /**
     * to String
     * @return toStrig
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + name + ":" + luckyNumber;
    }
    
    /**
     * equals
     * @param o object
     * @return equals
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof LuckyNumber) {
            if (((LuckyNumber) o).toString().equals(toString()))
                return true;
        }
        return false;
    }
    
}
