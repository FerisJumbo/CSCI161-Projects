package lib;

/**
 * Generic Interface of a comparator to compare two objects.
 * @author Cole Gartner
 * @version Nov 15, 2021
 * @param <K> Type
 */
public interface Comparator<K> {
    
    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    int compare( K a, K b );
}
