package lib;


/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.11
 * An implementation of a simple LinkedQueue class
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public class LinkedQueue<E> implements Queue<E> {
    
    // An empty list
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    
    /**
     * New queue relies on the initially empty list.
     */
    public LinkedQueue () { }
    
    /**
     * Returns the number of elements in the queue.
     * @return size
     */
    @Override
    public int size() { return list.size(); }
    
    /**
     * Tests whether the queue is empty.
     * @return isEmpty
     */
    @Override
    public boolean isEmpty() { return list.isEmpty(); }
    
    /**
     * Inserts an element at the rear of the queue.
     * @param e element
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        list.addLast(e);
    }
    
    /**
     * Returns, but does not remove, the first element
     * of the queue (null if empty).
     * @return first element
     */
    @Override
    public E first() { return list.first(); }
    
    /**
     * Removes and returns the first element of the queue
     * (null if empty).
     * @return first element
     */
    @Override
    public E dequeue() { return list.removeFirst(); }
}
