
/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.1
 * Stack ADT interface utilizing LIFO
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public interface Stack<E> {
    
    /**
     * Returns the number of elements in the stack.
     * @return number of elements in stack
     */
    int size();
    
    /**
     * Test whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    void push(E e) throws IllegalStateException;
    
    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null)
     */
    E top();
    
    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null)
     */
    E pop();
}
