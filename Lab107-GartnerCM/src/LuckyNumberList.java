
import java.util.NoSuchElementException;

/**
 * Holds objects of Lucky Number in a linked positional list
 * and has a default, even, and prime iterators.
 *
 * @author Cole Gartner
 * @version Oct 18, 2021
 */
public class LuckyNumberList {
    
    private LinkedPositionalList<LuckyNumber> pList;
    
    /**
     * Creates a new lucky number list.
     */
    public LuckyNumberList () {
        pList = new LinkedPositionalList<>();
    }
    
    /**
     * Adds a LuckyNumber object to the end of the list.
     * @param lN LuckyNumber
     */
    public void addLuckyNumber(LuckyNumber lN) {
        pList.addLast(lN);
    }
    
    /**
     * Is Even.
     * @param lN LuckyNumber
     * @return isEven
     */
    public boolean isEven(LuckyNumber lN) {
        return ((lN.getNumber() % 2) == 0) ? true : false;
    }
    
    /**
     * Is Prime.
     * @param lN LuckyNumber
     * @return isPrime
     */
    public boolean isPrime(LuckyNumber lN) {
        if (lN.getNumber() <= 1) {
            return false;
        }
        
        for (int i = 2; i < lN.getNumber(); i++)
            if (lN.getNumber() % i == 0)
                return false;
        
        return true;
    }
    
    /**
     * Default Iterator that iterates along all objects in the list.
     */
    private class defaultIterator implements Iterator<Position<LuckyNumber>> {
        
        private Position<LuckyNumber> cursor = pList.first();
        private Position<LuckyNumber> recent = null;
        
        /**
         * has Next
         * @return hasNext 
         */
        @Override
        public boolean hasNext() { return (cursor != null); }

        /**
         * Returns the next element
         * @return next element
         */
        @Override
        public Position<LuckyNumber> next() {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = pList.after(cursor);
            return recent;
        }

        /**
         * Removes the current element and waits for next to be called again.
         * @throws IllegalStateException IllegalStateException 
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            pList.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
        }
        
    }
    
    /**
     * Default Iterable class to get the Iterator
     */
    private class defaultIterable implements Iterable<Position<LuckyNumber>> {

        /**
         * Returns the iterator.
         * @return iterator
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new defaultIterator();
        }
        
    }
    
    /**
     * gets the default iterator.
     * @return default iterator
     */
    public Iterable<Position<LuckyNumber>> getIterable() {
        return new defaultIterable();
    }
    /**
     * Even Iterator that iterates along all even numbered LuckyNumbers in the list.
     */
    private class evenIterator implements Iterator<Position<LuckyNumber>> {
        
        private Position<LuckyNumber> cursor = pList.first();
        private Position<LuckyNumber> recent = null;
        
        /**
         * Has next.
         * @return hasNext 
         */
        @Override
        public boolean hasNext() { return (cursor != null); }

        /**
         * Returns the next element in the list and moves up the list.
         * @return next element
         */
        @Override
        public Position<LuckyNumber> next() {
            if ( recent == null )                                                    
            {                                                                        
                while (cursor != null && !isEven(cursor.getElement()))    
                    cursor = pList.after( cursor );                               
            }                                                                        
                
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = pList.after(cursor);
            
            while ( cursor != null && !isEven(cursor.getElement()))
                cursor = pList.after(cursor);
            
            return recent;
        }

        /**
         * Removes the current item tracked in the list.
         * @throws IllegalStateException IllegalStateException
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            pList.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
        }
        
    }
    
    /**
     * Holds the iterator for even numbers in the list.
     */
    private class evenIterable implements Iterable<Position<LuckyNumber>> {

        /**
         * Returns the iterator for even numbers.
         * @return evenIterator
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new evenIterator();
        }
        
    }
    
    /**
     * Gets the even Iterable.
     * @return evenIterable
     */
    public Iterable<Position<LuckyNumber>> getEvenIterable() {
        return new evenIterable();
    }
    
    /**
     * Prime iterator for all prime LuckyNumbers.
     */
    private class primeIterator implements Iterator<Position<LuckyNumber>> {
        
        private Position<LuckyNumber> cursor = pList.first();
        private Position<LuckyNumber> recent = null;
        
        /**
         * Has next.
         * @return hasNext
         */
        @Override
        public boolean hasNext() { return (cursor != null); }

        /**
         * Returns the next element in the list
         * @return next element
         */
        @Override
        public Position<LuckyNumber> next() {
            if ( recent == null )                                                    
            {                                                                        
                while (cursor != null && !isPrime(cursor.getElement()))    
                    cursor = pList.after( cursor );                               
            }                                                                        
                
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = pList.after(cursor);
            
            while ( cursor != null && !isPrime(cursor.getElement()))
                cursor = pList.after(cursor);
            
            return recent;
        }

        /**
         * Removes the current item and waits for a next call.
         * @throws IllegalStateException IllegalStateException
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            pList.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
        }
        
    }
    
    /**
     * Prime Iterable to get the prime iterator object.
     */
    private class primeIterable implements Iterable<Position<LuckyNumber>> {
        
        /**
         * returns the primeIterator
         * @return primeIterator
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new primeIterator();
        }
    }
    
    /**
     * Gets the Prime Iterable.
     * @return primeIterable
     */
    public Iterable<Position<LuckyNumber>> getPrimeIterable() {
        return new primeIterable();
    }
    
}
