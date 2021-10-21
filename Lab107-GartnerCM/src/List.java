/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.9
 * A simplified version fo the java.util.List interface.
 * 
 * @author Cole Gartner
 * @version Oct 18, 2021
 * @param <E> type
 */
public interface List<E> {
    
    /**
     * Returns the number of elements in this list.
     * @return size
     */
    int size();
    
    /**
     * Returns whether the list is empty.
     * @return isEmpty
     */
    boolean isEmpty();
    
    /**
     * Returns (but does not remove) the element at index i.
     * @param i index
     * @return element
     * @throws IndexOutOfBoundsException IndexOutOfBoundsException
     */
    E get(int i) throws IndexOutOfBoundsException;
    
    /**
     * Replaces the element at index i with e, and returns the replaced element.
     * @param i index
     * @param e element
     * @return element at index i
     * @throws IndexOutOfBoundsException IndexOutOfBoundsException
     */
    E set(int i, E e) throws IndexOutOfBoundsException;
    
    /**
     * Inserts element e to be at index i shifting all subsequent elements later.
     * @param i index
     * @param e element
     * @throws IndexOutOfBoundsException IndexOutOfBoundsException
     */
    void add(int i, E e) throws IndexOutOfBoundsException;
    
    /**
     * Removes/returns the element at index i, shifting subsequent elements earlier.
     * @param i index
     * @return Element
     * @throws IndexOutOfBoundsException IndexOutOfBoundsException
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
