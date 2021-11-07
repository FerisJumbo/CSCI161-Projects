package lib;



/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * An interface for a binary tree, in which each node has at most two
 * children.
 * 
 * @author Cole Gartner
 * @version Oct 21, 2021
 * @param <E> type
 */
public interface BinaryTree<E> extends Tree<E> {
    
    /**
     * Returns the Position of p's left child (or null if no child exists).
     * @param p Position
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the Position of p's right child (or null if no child exists).
     * @param p Position
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     * @param p Position
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
    
}
