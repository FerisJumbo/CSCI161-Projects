package lib;


/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * An abstract base class providing some functionality of the Tree interface.
 * 
 * @author Cole Gartner
 * @version Oct 21, 2021
 * @param <E> type
 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    /**
     * Returns if node is Internal.
     * @param p Position
     * @return isInternal
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    
    /**
     * Returns if node is External.
     * @param p Position
     * @return isExternal
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
    
    /**
     * Returns if node is Root of tree.
     * @param p Position
     * @return Root
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public boolean isRoot(Position<E> p) { return p == root(); }
    
    /**
     * Returns if the tree is empty.
     * @return isEmpty
     */
    @Override
    public boolean isEmpty() { return size() == 0; }
    
    /**
     * Returns the number of levels separating Position p from the root.
     * @param p Position
     * @return depth
     */
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    
    /**
     * Returns the height of the tree.
     * @param p Position
     * @return height
     */
    public int height(Position<E> p) {
        int h= 0; // base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
    
}
