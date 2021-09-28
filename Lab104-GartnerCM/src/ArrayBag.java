
import java.util.Random;

/**
 * ArrayBag holds numbers in a list (bag) and has methods to modify that bag.
 *
 * @author Cole Gartner
 * @version Sep 20, 2021
 * @param <E> type
 */
public class ArrayBag<E> implements Bag<E> {
    
    private E[] bag;
    private int size;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">

    /**
     * Creates a base array of bag with a size of 2
     */
    public ArrayBag() { bag = (E[]) new Object[2]; size = 0; }
    
    /**
     * Creates a base array of bag with a size of num.
     * @param num size
     */
    public ArrayBag(int num) {
        bag = (E[]) new Object[num];
        size = 0;
    }
    
    // </editor-fold>

    /**
     * returns the length of list bag
     * @return capacity
     */
    public int capacity() { return bag.length; }
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        size = 0;
        
        for (int i = 0; i < bag.length; i++) {
            bag[i] = (E) new Object();
        }
    }

    @Override
    public int getFrequencyOf(E e) {
        int count = 0;
        
        for (E element : bag) {
            if (e.equals(element)) count++;
        }
        
        return count;
    }

    @Override
    public boolean contains(E e) {
        for (E element : bag) {
            if (e.equals(element)) return true;
        }
        
        return false;
    }

    @Override
    public void add(E e) {
        if (size < capacity()) {
            bag[size] = e;
            size++;
        }
        else {
            E[] temp = (E[]) new Object[capacity() + 1];
            for (int i = 0; i < capacity(); i++) {
                temp[i] = bag[i];
            }
            bag = temp;
            add(e);
        }
    }

    @Override
    public E remove(E e) {
        int index = -1;
        E element = null;
        
        for (int i = 0; i < capacity(); i++) {
            if (e.equals(bag[i])) {
                index = i;
                element = bag[i];
                break;
            }
        }
        
        if (index != - 1) {
            for (int i = index; i < size()-1; i++) {
                bag[i] = bag[i + 1];
            }
            size--;
        }
        
        return element;
    }

    @Override
    public E remove() {
        Random rand = new Random();
        return remove(bag[rand.nextInt(bag.length)]);
    }

    @Override
    public E get(int i) { return bag[i]; }
    
    @Override
    public String toString() {
        String builder = getClass().getName() + "@[";
        for (int i = 0; i < size(); i++) {
            if (bag[i].equals(bag[size()-1])) builder += bag[i].toString() + "]";
            else builder += bag[i].toString() + ",";
        }
        builder += ":" + size;
        return builder;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayBag) {
            if (((E) o).toString().equals(this.toString())) 
                return true;
        }
        return false;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    // No Getters & Setters because we don't want the client to be able to access
    // private variables.
    
    // </editor-fold>

    
}
