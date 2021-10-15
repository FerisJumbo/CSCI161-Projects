
/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.10
 * An implementation of a simple ArrayQueue class
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public class ArrayQueue<E> implements Queue<E> {
    
    // Instance variables
    
    /** default array capacity */
    public static final int CAPACITY = 1000;
    
    // Generic array used for storage
    private E[] data;
    
    // Index of the front element
    private int f = 0;
    
    // current number of elements
    private int sz = 0;
    
    
    // Constructors
    
    /**
     * Default Constructor.
     */
    public ArrayQueue() { this(CAPACITY); }
    
    /**
     * Constructs the array with a capacity.
     * @param capacity capacity
     */
    public ArrayQueue(int capacity) {
        // safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }
    
    
    // Methods

    /**
     * Returns the number of elements in the queue.
     * @return size
     */
    @Override
    public int size() { return sz; }
    
    /**
     * Tests whether the queue is empty.
     * @return isEmpty
     */
    @Override
    public boolean isEmpty() { return sz == 0; }
    
    /**
     * Inserts an element at the rear of the queue.
     * @param e element
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length; // use modular arithmetic
        data[avail] = e;
        sz++;
    }
    
    /**
     * Returns, but does not remove, the first element
     * of the queue (null if empty).
     * @return first element
     */
    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }
    
    /**
     * Removes and returns the first element of the queue
     * (null if empty).
     * @return first element
     */
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null; // Dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
