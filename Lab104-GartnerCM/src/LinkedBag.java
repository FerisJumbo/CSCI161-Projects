
import java.util.Random;

/**
 * Same thing as ArrayBag, but uses singly linked list rather than
 * java array.
 *
 * @author Cole Gartner
 * @version Sep 21, 2021
 * @param <E> type
 */
public class LinkedBag<E> implements Bag<E> {
    
    private SinglyLinkedList<E> bag;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">

    /**
     * Creates a new Linked Bag
     */
    public LinkedBag() { bag = new SinglyLinkedList<>(); }
    
    /**
     * Creates a new LinkedBag
     * @param num size
     */
    public LinkedBag(int num) { this(); }
    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    @Override
    public int size() { return bag.size(); }

    @Override
    public boolean isEmpty() { return bag.isEmpty(); }

    @Override
    public void clear() {
        while (true) {
            if (bag.removeFirst() == null) break;
        }
    }

    @Override
    public int getFrequencyOf(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < bag.size(); i++) {
            E element = bag.removeFirst();
            
            if (e.equals(element)) return true;
            
            bag.addLast(element);
        }
        return false;
    }

    @Override
    public void add(E e) { bag.addLast(e); }

    @Override
    public E remove(E e) {
        E removedElement = null;
        boolean found = false;
        
        if (bag.isEmpty()) return null;
        for (int i = 0; i <= bag.size(); i++) {
            E element = bag.removeFirst();
            
            if (e.equals(element) && !found) {
                found = true;
                removedElement = element;
                continue;
            }
            
            bag.addLast(element);
        }
        return removedElement;
    }

    @Override
    public E remove() {
        Random rand = new Random();
        E element = get(rand.nextInt(size()));
        return remove(element);
    }

    @Override
    public E get(int i) {
        E returnElement = null;
        if (i >= 0 || i < bag.size()) {
            boolean found = false;
            for (int j = 0; j < bag.size(); j++) {
                E element = bag.removeFirst();

                if (i == j && !found) {
                    found = true;
                    returnElement = element;
                }

                bag.addLast(element);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return returnElement;
    }
    
    @Override
    public String toString() {
        String builder = getClass().getName() + "@[";
        for (int i = 0; i < bag.size(); i++) {
            E element = bag.removeFirst();
            if ( i == size()) { builder += element.toString() + "]"; }
            else { builder += element.toString() + ","; }
            bag.addLast(element);
        }
        return builder;
    }
    
    @Override
    public boolean equals( Object o ) {
        if (o instanceof LinkedBag) {
            if (((LinkedBag) o).toString().equals(this.toString())) {
                return true;
            }
        }
        return false;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    // No Getters or Setters because we don't want the client interacting
    // with class variables.
    
    // </editor-fold>
}
