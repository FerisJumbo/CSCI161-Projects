
/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.2
 * An implementation of a simple ArrayStack class
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public class ArrayStack<E> implements Stack<E> {

    /** Default array capacity. */
    public static final int CAPACITY = 1000;
    private E[] data; // generic array used for storage
    private int t = -1; // index of the top element in stack

    /**
     * Constructs stack with default capacity
     */
    public ArrayStack() { this(CAPACITY); }
    
    /**
     * Construct stack with given capacity
     * @param capacity capacity
     */
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }
    
    /**
     * Returns the number of elements in the stack.
     * @return number of elements in stack
     */
    @Override
    public int size() { return t+1; }

    /**
     * Test whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return t == -1; }

    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    @Override
    public void push(E e) throws IllegalStateException{
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++t] = e; // increment t before storing new item
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null)
     */
    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null)
     */
    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }
    
}
