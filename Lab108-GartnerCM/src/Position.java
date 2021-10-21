
/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 7.7
 * 
 * @author Cole Gartner
 * @version Oct 18, 2021
 * @param <E> type
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position.
     * 
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement( ) throws IllegalStateException;
}
