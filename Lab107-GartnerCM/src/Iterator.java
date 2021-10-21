/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.9
 * Section 7.4
 * 
 * @author Cole Gartner
 * @version Oct 18, 2021
 * @param <E> type
 */
public interface Iterator<E> {
    
    /**
     * Returns true if there is at least one additional element
     * in the sequence, and false otherwise.
     * @return hasNext
     */
    boolean hasNext( );
    
    /**
     * Returns the next element in the sequence.
     * @return next element
     */
    E next( );
    
    /**
     * Removes from the collection the element returned by the
     * most recent call to next().  Throws an IllegalStateException if
     * next has not yet been called, or if remove was already called since the
     * most recent call to next.
     * @throws IllegalStateException IllegalStateException
     */
    void remove( ) throws IllegalStateException;
    
}
