/**
 * Singly Linked List Class from textbook (Data Structures and Algorithms in
 * Java).
 * by Michael T. Goodrich, Roberto Tamassia and Michael H. Goldwasser
 * Wiley 2014.
 * 
 * Transcribed by
 * @author Cole Gartner
 * @version Sep 21, 2021
 * @param <E> type
 */
public class SinglyLinkedList<E> {
    //---------------- nested Node class ----------------
    /**
     * Node Class to store list nodes.
     * 
     * @param <E> type
     */
    private static class Node<E> {
        private E element;                // reference to the element stored at this node
        private Node<E> next;             // reference to the subsequent node in the list
        
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        
        public E getElement( ) { return element; }
        
        public Node<E> getNext( ) { return next; }
        
        public void setNext(Node<E> n) { next = n; }
    }
    //----------- end of nested Node class ------------
    
    // instance variables of the SinglyLinkedList
    private Node<E> head = null;             // head node of the list (or null if empty)
    private Node<E> tail = null;             // last node of the list (or null if empty)
    private int size = 0;                    // number of nodes in the list
    
    /**
     *constructs an initially empty list
     */
    public SinglyLinkedList( ) { }
    
    // access methods

    /**
     * returns the size of the linkedList
     * @return size
     */
    public int size( ) { return size; }
    
    /**
     * @return isEmpty
     */
    public boolean isEmpty( ) { return size == 0; }
    
    /**
     * returns (but does not remove) the first element
     * @return first element
     */
    public E first( ) {
        if (isEmpty( )) return null;
        return head.getElement( );
    }
    
    /**
     * returns (but does not remove) the last element
     * @return last element
     */
    public E last( ) {
        if (isEmpty( )) return null;
        return tail.getElement( );
    }
    
    // update methods

    /**
     * adds element e to the front of the list
     * @param e element
     */
    public void addFirst(E e) {
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) tail = head; // special case: new node becomes tail also
        size++;
    }
    
    /**
     * adds element e to the end of the list
     * @param e element
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);   // node will eventually be the tail
        if (isEmpty( )) head = newest;          // special case: previously empty list
        else tail.setNext(newest);              // new node after existing tail
        tail = newest;                          // new node becomes the tail
        size++;
    }
    
    /**
     * removes and returns the first element
     * @return removed element
     */
    public E removeFirst( ) {
        if (isEmpty( )) return null;    // nothing to remove
        E answer = head.getElement( );
        head = head.getNext( );         // will become null if list had only one node
        size--;
        if (size == 0) tail = null;     // special case as list is now empty
        return answer;
    }
}