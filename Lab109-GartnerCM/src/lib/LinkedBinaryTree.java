package lib;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data Structures and Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Concrete implementation of a BinaryTree using LinkedLists and nodes.
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 * @param <E> type
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    //----- nested Node class -----
    /**
     * Node class which stores element, parent node, left node, right node.
     * @param <E> type
     */
    protected static class Node<E> implements Position<E>{

        private E element; // an element stored at this node
        private Node<E> parent; // reference to the parent node(if any)
        private Node<E> left; // reference to the left child (if any)
        private Node<E> right; // reference to the right child (if any)
        
        /**
         * Creates a new node
         * @param e Element
         * @param above Parent
         * @param leftChild Left
         * @param rightChild Right
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        
        // accessor methods
        
        /**
         * Returns the element stored at this position.
         * 
         * @return the stored element
         * @throws IllegalStateException if position no longer valid
         */
        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
        
        /**
         * Returns Parent node.
         * @return parent node
         */
        public Node<E> getParent() { return parent; }
        
        /**
         * Returns left node.
         * @return left node
         */
        public Node<E> getLeft() { return left; }
        
        /**
         * Returns right node.
         * @return right node
         */
        public Node<E> getRight() { return right; }
        
        
        // update methods
        
        /**
         * Sets the element.
         * @param e element
         */
        public void setElement(E e) { element = e; }
        
        /**
         * Set Parent node
         * @param parentNode parent node
         */
        public void setParent(Node<E> parentNode) { parent = parentNode; }
        
        /**
         * Set left node.
         * @param leftChild left node 
         */
        public void setLeft(Node<E> leftChild) { left = leftChild; }
        
        /**
         * Set right node.
         * @param rightChild right node 
         */
        public void setRight(Node<E> rightChild) { right = rightChild; }
        
    }
    //----- end fo nested Node class -----
    
    /**
     * Factory function to create a new node storing element e.
     * @param e element
     * @param parent parent node
     * @param left left child
     * @param right right child
     * @return new node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }
    
    // LinkedBinaryTree instance variables
    /** root of the tree */
    protected Node<E> root = null;
    private int size = 0; // number of nodes in the tree
    
    /**
     * constructs an empty binary tree
     */
    public LinkedBinaryTree() { }
    
    // nonpublic utility
    
    /**
     * Validates that a Position is of type Node and in the tree.
     * Explicitly morphs p into a Node object
     * @param p Position
     * @return Node
     * @throws IllegalArgumentException IllegalArgumentException
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    
    // accessor methods (not already implemented in AbstractTree
    
    /**
     * Returns the size of the tree.
     * @return size
     */
    @Override
    public int size() { return size; }
    
    /**
     * Returns the root node.
     * @return root node
     */
    @Override
    public Position<E> root() { return root; }
    
    /**
     * Returns the parent node.
     * @param p Position
     * @return Parent node
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    
    /**
     * Returns the Position of p's left child (or null if no child exists).
     * @param p Position
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    
    /**
     * Returns the Position of p's right child (or null if no child exists).
     * @param p Position
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }
    
    // update methods supported by this class
    
    /**
     * Adds the element as the root position
     * @param e Element
     * @return Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    
    /**
     * Creates a new left child of Position p storing element e.
     * returns its Position
     * @param p Position
     * @param e element
     * @return New Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    
    /**
     * Creates a new right child of Position p storing element e.
     * returns its Position
     * @param p Position
     * @param e element
     * @return New Position
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    
    /**
     * Replaces the element at Position p with e and returns the replaced element.
     * @param p Position
     * @param e Element
     * @return replaced element
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    
    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     * @param p Position
     * @param t1 Tree 1
     * @param t2 Tree 2
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                        LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as left subree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    
    /**
     * Removes the position from the tree if it doesn't have 2 children.
     * @param p Position
     * @return element
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); // child's grandparent becomes parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }
    
    // ----- nested ElementIterator class -----
    /**
     * This class adapts the iteration produced by positions() to return elements.
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() { return posIterator.hasNext(); }
        
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() { return posIterator.next().getElement(); } // return element!
        
        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @implSpec
         * The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *         operation is not supported by this iterator
         *
         * @throws IllegalStateException if the {@code next} method has not
         *         yet been called, or the {@code remove} method has already
         *         been called after the last call to the {@code next}
         *         method
         */
        @Override
        public void remove() { posIterator.remove(); }
    }
    
    /**
     * Returns an iterator for the tree.
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() { return new ElementIterator(); }
    
    /**
     * Returns an Iterable for all positions in a tree.
     * @return Iterable
     */
    @Override
    public Iterable<Position<E>> positions() { return preorder(); }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * @param p
     * @param snapshot 
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }
    
    /**
     * Returns an iterable collection of positions of the tree, reported in preorder.
     * @return preorder
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }
    
    /**
     * Adds positions p to the snapshot after each loop
     * @param p Position
     * @param snapshot snapshot
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p); // for postorder we add position p after exploring subtrees
    }
    
    /**
     * Returns an iterable collection of positions of the tree, reported in postorder.
     * @return postorder
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }
    
    /**
     * Returns an iterable collection of positions of the tree in breadth-first order.
     * @return breathfirst order
     */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.enqueue(c); // add children to back of queue
            }
        }
        return snapshot;
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     * @param p Position
     * @param snapshot snapshot
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }
    
    /**
     * Returs an iterable collection of positions of the tree, reported in inorder.
     * @return inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    private String snapshot = "";
    
    /**
     * Recursive method to be called from eulerParenthasize() travels through the
     * tree using eulers path and puts it in parenthases to determine inner and outer
     * nodes.
     * @param p Position.
     */
    private void eulerParenthasizeAlg(Position<E> p) {
        if (isInternal(p))
            snapshot += "( ";
        
        if (left(p) != null)
            eulerParenthasizeAlg(left(p));
        
        snapshot += (" " + p.getElement().toString() + " ");
        
        if (right(p) != null)
            eulerParenthasizeAlg(right(p));
        
        if (isInternal(p))
            snapshot += " )";
    }
    
    /**
     * Returns a string of the complete tree traveled through with eulers method
     * and Parenthasizes them to determine inner and outer nodes.
     * @param p Position
     * @return Parenthasized tree
     */
    public String eulerParenthasize(Position<E> p) {
        snapshot = "";
        eulerParenthasizeAlg(p);
        return snapshot;
    }
}
