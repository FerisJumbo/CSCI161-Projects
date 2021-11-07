package lib;


import java.util.ArrayList;
import java.util.List;

/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * A partially complete class for bBinaryTree's that implements some classes
 * from BinaryTree.
 * 
 * @author Cole Gartner
 * @version Oct 21, 2021
 * @param <E> type
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
                                            implements BinaryTree<E>{
    
    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     * @param p Position
     * @return Position
     */
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null; // p must be the root
        if (p == left(parent)) // p is a left child
            return right(parent); // (right child might be null)
        else // p is a right child
            return left(parent); // (left child might be null)
    }
    
    /**
     * Returns the number of children of Position p.
     * @param p Position
     * @return number of children
     */
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }
    
    /**
     * Returns an iterable collection of the Position representing p's children
     * @param p Position
     * @return Iterable
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }
}
