/**
 * A generic version of a bag.
 * @author Cole Gartner
 * @version Sep 20, 2021
 * @param <E> type
 */
public interface Bag<E> {
    
    /**
     * returns the size of the bag.
     * @return size
     */
    int size();
    
    /**
     * returns if the bag is empty or not.
     * @return isEmpty
     */
    boolean isEmpty();
    
    /**
     * Clears the bag.
     */
    void clear();
    
    /**
     * Returns the frequency of item E.
     * @param e element
     * @return count
     */
    int getFrequencyOf(E e);
    
    /**
     * Checks to see if Element E is in the bag.
     * @param e element
     * @return contains
     */
    boolean contains(E e);
    
    /**
     * Adds element E to the next available position.
     * @param e element
     */
    void add(E e);
    
    /**
     * Removes the first element E occurence in the bag.
     * @param e element
     * @return element
     */
    E remove(E e);
    
    /**
     * Removes a random element from bag.
     * @return random element
     */
    E remove();
    
    /**
     * returns the element in index i.
     * @param i index
     * @return element
     */
    E get(int i);
    
    /**
     * To String method
     * @return toString
     */
    @Override
    String toString();
    
    /**
     * Checks to see if the two objects are equal to each other.
     * @param o object
     * @return equals
     */
    @Override
    boolean equals(Object o);
    
    
}
