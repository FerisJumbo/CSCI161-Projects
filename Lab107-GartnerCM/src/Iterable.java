/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.9
 * Section 7.4.1
 * 
 * @author Cole Gartner
 * @version Oct 18, 2021
 * @param <E> type
 */
public interface Iterable<E> {
    
    /**
     * Returns an iterator of the elements in the collection.
     * @return Iterator
     */
    Iterator<E> iterator( );
   
}
