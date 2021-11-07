package lib;


/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.4
 * An implementation of a simple LinkedStack class
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public class LinkedStack<E> implements Stack<E> {

    // An empty list
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    
    /**
     * New stack relies on the initially empty list
     */
    public LinkedStack() { }

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in stack
     */
    @Override
    public int size(){ return list.size(); }
    
    /**
     * Test whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty(){ return list.isEmpty(); }
    
    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    @Override
    public void push(E e){ list.addFirst(e); }
    
    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null)
     */
    @Override
    public E top() { return list.first(); }
    
    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null)
     */
    @Override
    public E pop() { return list.removeFirst(); }
    
}
