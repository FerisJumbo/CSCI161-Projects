package program;

import lib.Comparator;


/**
 * Compares Id's of Students.
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class IntegerComparator implements Comparator<Integer> {

    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) return -1;
        else if (a == b) return 0;
        else return 1;
    }
    
}
