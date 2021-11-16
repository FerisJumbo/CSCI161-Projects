package program;

import java.util.Arrays;
import lib.LinkedQueue;
import lib.Queue;

/**
 * This is a container class for sorting algorithms.
 * 
 * Algorithms:
 * [X] Merge Sort 
 * [X] Quick Sort
 * [X] Insertion Sort
 * [X] Selection Sort
 * [X] Bubble Sort
 * [X] Efficient Bubble Sort
 * [X] Radix Sort
 * 
 * @author Cole Gartner
 * @version Nov 11, 2021
 */
public class Sort {
    
    /**
     * Splits the array recursivly until trivaly sorted then merges each split
     * array together.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // Array is sorted by default.
        
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        
        // conquer (with recursion)
        mergeSort(S1, comp); // sort copy of first half
        mergeSort(S2, comp); // sort copy of second half
        
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }
    
    /**
     * Merges two arrays together into one array.
     * @param <K> Type
     * @param S1 Array 1
     * @param S2 Array 2
     * @param S Sort array
     * @param comp Comparator
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i+j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j])  < 0))
                S[i+j] = S1[i++]; // copy ith element of S1 and increment i
            else
                S[i+j] = S2[j++]; // copy jth element of S2 and increment j
        }
    }
    
    /**
     * Picks a object in the center of the list as a pivot, then puts all objects
     * less than pivot in the left, equal in the equal, and greater than in the right
     * queue.  Recursivly goes through left and right side until trivaly sorted and
     * merges left and right back into the original queue.
     * @param <K> Type
     * @param S Queue
     * @param comp Comparator
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) return; // queue is trivially sorted
        
        // divide
        K pivot = S.first(); // using first as arbitrary pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) {
        // divide original into L, E, and G
        K element = S.dequeue();
        int c  = comp.compare(element, pivot);
        if (c < 0) // element is less than pivot
            L.enqueue(element);
        else if (c == 0) // elment is equal to pivot
            E.enqueue(element);
        else // element is greater than pivot
            G.enqueue(element);
        }
        // conquer
        quickSort(L, comp); // sort elements less than pivot
        quickSort(G, comp); // sort elemnts greater than pivot
        // concatenate results
        while (!L.isEmpty())
            S.enqueue(L.dequeue());
        while (!E.isEmpty())
            S.enqueue(E.dequeue());
        while (!G.isEmpty())
            S.enqueue(G.dequeue());
    }
    
    /**
     * Picks a key value that is iterated throughout the 2nd value and last value
     * of the array and shifts the array right from left on each unsorted value.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void insertionSort(K[] S, Comparator comp) {
        int n = S.length;
        for (int i = 1; i < n; i++) {
            K key = S[i];
            int j = i-1;
            while ( (j > -1) && (comp.compare(S[j], key) == 1) ) {
                S[j+1] = S[j];
                j--;
            }
            S[j+1] = key;
        }
    }
    
    /**
     * Selects the lowest number in a list and moves to the left. Continues this
     * for every element in the array.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void selectionSort(K[] S, Comparator comp) {
        for (int i = 0; i < S.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < S.length; j++) {
                if (comp.compare(S[minIndex], S[j]) >= 0) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                K temp = S[i];
                S[i] = S[minIndex];
                S[minIndex] = temp;
            }
        }
    }
    
    /**
     * Takes the first element and compares it to its next, then goes to the next
     * element and compares it to its next and so on until the end of the array,
     * repeats this process for the length of the array.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void bubbleSort(K[] S, Comparator comp) {
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S.length - 1; j++) {
                if (comp.compare(S[j], S[j+1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j+1];
                    S[j+1] = temp;
                }
            }
        }
    }
    
    /**
     * Same thing as the bubble sort, however if no swaps were made in a outer
     * loop pass, the array is sorted and doesn't continue.  Also since the values
     * at the back half of the array are trivaly sorted, we can ignore the last value
     * after each outer loop pass causing the inner loop to shorten by one every time.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void efficientBubbleSort(K[] S, Comparator comp) {
        for (int i = 0; i < S.length; i++) {
            boolean hasSwapped = false;
            for (int j = 0; j < S.length-1-i; j++) {
                if (comp.compare(S[j], S[j+1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j+1];
                    S[j+1] = temp;
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) return;
        }
    }
    
    /**
     * Compares and sorts items using a merge sort, however comp1 is the leading
     * sort, and comp2+ are following sorts in that order to produce a list that
     * is multi-sorted.
     * @param <K> Type
     * @param S Array
     * @param comp1 Comp1
     * @param comp2 Comp2
     * @param comp3 Comp3
     * @param comp4 Comp4
     * @param comp5 Comp5
     */
    public static <K> void radixSort(K[] S, Comparator<K> comp1, Comparator<K> comp2,
            Comparator<K> comp3, Comparator comp4, Comparator comp5) {
        if (comp2 == null || comp1 == null)
            throw new IllegalArgumentException("Needs to have 2-5 comparators.");
        if (comp5 != null)
            mergeSort(S, comp5);
        if (comp4 != null)
            mergeSort(S, comp4);
        if (comp3 != null)
            mergeSort(S, comp3);
        mergeSort(S, comp2);
        mergeSort(S, comp1);
    }
}
