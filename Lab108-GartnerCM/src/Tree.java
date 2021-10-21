
import java.util.Iterator;

/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * An interface for a tree where nodes can have an arbitrary number of children
 * 
 * @author Cole Gartner
 * @version Oct 21, 2021
 * @param <E> type
 */
public interface Tree<E> extends Iterable<E> {
    
    /**
     * Returns the root node.
     * @return root node
     */
    Position<E> root();
    
    /**
     * Returns the parent node.
     * @param p Position
     * @return Parent node
     * @throws IllegalArgumentException IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns an iterable object of all the children on a node.
     * @param p Position
     * @return Iterable
     * @throws IllegalArgumentException IllegalArgumentException
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    
    
    /**
     * Counts the number of children.
     * @param p Position
     * @return number of children
     * @throws IllegalArgumentException IllegalArgumentException
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if node is Internal.
     * @param p Position
     * @return isInternal
     * @throws IllegalArgumentException IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if node is External.
     * @param p Position
     * @return isExternal
     * @throws IllegalArgumentException IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if node is Root of tree.
     * @param p Position
     * @return Root
     * @throws IllegalArgumentException IllegalArgumentException
     */
    boolean isRoot(Position<E> p)  throws IllegalArgumentException;
    
    /**
     * Returns the size of the tree.
     * @return size
     */
    int size();
    
    /**
     * Returns if the tree is empty.
     * @return isEmpty
     */
    boolean isEmpty();
    
    /**
     * Returns an iterator for the tree.
     * @return iterator
     */
    Iterator<E> iterator();
    
    /**
     * Returns an Iterable for all positions in a tree.
     * @return Iterable
     */
    Iterable<Position<E>> positions();
}
