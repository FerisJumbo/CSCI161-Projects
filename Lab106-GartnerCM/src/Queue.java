
/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.9
 * Queue ADT interface implementing FIFO
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public interface Queue<E> {
    
    /**
     * Returns the number of elements in the queue.
     * @return size
     */
    int size();
    
    /**
     * Tests whether the queue is empty.
     * @return isEmpty
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the rear of the queue.
     * @param e element
     */
    void enqueue(E e) throws IllegalStateException;
    
    /**
     * Returns, but does not remove, the first element
     * of the queue (null if empty).
     * @return first element
     */
    E first();
    
    /**
     * Removes and returns the first element of the queue
     * (null if empty).
     * @return first element
     */
    E dequeue();
}
