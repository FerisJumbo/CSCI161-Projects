
import java.util.Random;

/**
 * Scores holds numbers in a list (bag) and has methods to modify that bag.
 *
 * @author Cole Gartner
 * @version Sep 12, 2021
 */
public class Scores {
    
    /** The default values that is set when creating a bag. */
    public final int DEFAULT_VALUE = Integer.MIN_VALUE;
    
    private int[] bag;
    private int initSize;
    
    private int count;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">
    
    /**
     * Creates a bag that has a capacity of 2.
     */
    public Scores() {
        initSize = 2;
        makeNewBag();
    }
    
    /**
     * Creates a bag that has a capacity of num.
     * @param num size
     */
    public Scores(int num) {
        initSize = num < 2 ? 2 : num;
        makeNewBag();
    }
    
    // </editor-fold>
    
    /**
     * Used to make new bags that are initialized with all values set to DEFAULT_VALUE.
     */
    private void makeNewBag() {
        setBag(new int[getInitSize()]);
        
        for (int i = 0; i < bag.length; i++) {
            bag[i] = DEFAULT_VALUE; // Sets every value to the min to check for empty locations
        }
        
        setCount(0);
    }
    
    /** Same thing as getCount().
     * @return count
     */
    public int size() { return getCount(); }
    
    /** Returns the length of the bag.
     * @return capacity
     */
    public int capacity() { return bag.length; }
    
    /** Checks to see if the bag contains all DEFAULT_VALUEs.
     * @return isEmpty
     */
    public boolean isEmpty() {
        for (int i : bag) {
            if (i != DEFAULT_VALUE)
                return false;
        }
        return true;
    }
    
    /** Makes a new bag with the same initial size. */
    public void clear() {
        makeNewBag();
    }
    
    /**
     * Gets the frequency that num is counted in the bag.
     * @param num number
     * @return frequency
     */
    public int getFrequencyOf(int num) {
        int freq = 0;
        for (int i : bag) {
            if (i == num)
                freq++;
        }
        return freq;
    }
    
    /**
     * Checks to see if the bag contains a specific number.
     * @param num number
     * @return contains
     */
    public boolean contains(int num) {
        for (int i : bag) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Will add the number to the bag in the next DEFAULT_VALUE spot or if no open
     * spots are left, it will make the bag capacity increase by one and add the
     * number to the end.
     * @param num number
     */
    public void add(int num) {
        setCount(getCount() + 1);
        if (contains(DEFAULT_VALUE)) {
        
            for (int i = 0; i < bag.length; i++) {
                if (bag[i] == DEFAULT_VALUE) {
                    bag[i] = num;
                    break;
                }
            }
            
        } else {
            
            setInitSize(getInitSize() + 1);
            int[] temp = new int[getInitSize()];
            for (int i = 0; i < bag.length; i++) {
                temp[i] = bag[i];
            }
            temp[getInitSize() - 1] = num;
            setBag(temp);
            
        }
    }
    
    /**
     * Removes the first instance of the number in the bag and shifts all
     * values to the right of it by one to the left and fills the last index
     * with a DEFAULT_VALUE.
     * @param num number
     */
    public void remove(int num) {
        setCount(getCount() - 1);
        int index = -1;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == num) {
                bag[i] = DEFAULT_VALUE;
                index = i;
                break;
            }
        }
        
        if (index > -1) {
            for (int i = index; i < bag.length - 1; i++) {
                bag[i] = bag[i+1];
            }
            bag[bag.length-1] = DEFAULT_VALUE;
        }
    }
    
    /** Picks a random number and calls remove(num) to remove a random number. */
    public void remove() {
        int rng = new Random().nextInt(bag.length);
        remove(bag[rng]);
    }
    
    /**
     * Returns the value of the index specified.
     * @param i index
     * @return value
     */
    public int get(int i) { return bag[i]; }
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    /**
     * toString Method
     * @return toString
     */
    @Override
    public String toString() {
        String items = "[";
        for (int i = 0; i < bag.length-1; i++) {
            items += bag[i] + ",";
        }
        items += bag[bag.length-1] + "]";
        
        return getClass().getName() + "@" + items + ":" + DEFAULT_VALUE + ":" + getCount() + ":" + getInitSize();
    }
    
    /**
     * Checks to see if the object is equal to this object.
     * @param obj object
     * @return equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Scores s) {
            if (s.toString().equals(toString()))
                return true;
        }
        return false;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    /**
     * @return the bag
     */
    public int[] getBag() {
        return bag;
    }

    /**
     * @param bag the bag to set
     */
    public void setBag(int[] bag) {
        this.bag = bag;
    }

    /**
     * @return the initSize
     */
    public int getInitSize() {
        return initSize;
    }

    /**
     * @param initSize the initSize to set
     */
    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    // </editor-fold>
}
