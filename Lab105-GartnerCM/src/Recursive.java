
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Holds 3 public methods that can be accessed statically and all deal with
 * recursive functionality.
 *
 * @author Cole Gartner
 * @version Sep 28, 2021
 */
public class Recursive {
    
    /**
     * Sums 1/n for values between 1-n specificed by the user.
     * Calls recursive method harmonicRecursive(int n) to calculate value
     * while this method mearly checks for input correctness.
     * @param n natural number > 0
     * @return 1/n for all values 1-n
     */
    public static double harmonic(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n has to be a natural number greater than 0");
        }
        
        return harmonicRecursive(n);
    }
    
    /**
     * Helper recursive method for calculating harmonics.
     * use harmonic(int n) instead of a direct call to here.
     * @param n natural number > 0
     * @return 1/n for all values 1-n
     */
    private static double harmonicRecursive(double n) {
        if (n == 1) {
            return 1;
        }
        return 1/n + harmonicRecursive((int) n-1);
    }
    
    /**
     * Converts a file full of integers to an array of integers with a delimiter
     * of "\\s" (white space).
     * @param filePath
     * @return array of integers
     * @throws java.io.FileNotFoundException
     */
    public static int[] fileToIntArray(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fileIn = new Scanner(file);
        fileIn.useDelimiter("\\s");
        
        int length = 0;
        while (fileIn.hasNext()) {
            try {
                int debug = Integer.parseInt(fileIn.next());
                length++;
            } catch (Exception e) { }
        }
        
        fileIn = new Scanner(file); // Reset scanner
        fileIn.useDelimiter("\\s");
        int[] intArray = new int[length];
        
        int current = 0;
        while(fileIn.hasNext()) {
            try {
                intArray[current] = Integer.parseInt(fileIn.next());
                current++;
            } catch (Exception e) { }
        }
        
        return intArray;
    }
    
    /**
     * Implements Isabels technique on summing an array of integers in
     * C-5.24 in the textbook on page 223.
     * @param A array of integers
     * @return sum
     */
    public static int isabelsMethod(int[] A) {
        
        // *Initial Check to make array length a power of 2*
        int n = A.length;
        int power = 1;
        for (int i = power; i < 31; i++) { // Can only check up to 2^31 as that is the max positive integer
            if (Math.pow(2, i) >= n) {
                power = i;
                break;
            }
        }
        int difference = (int) Math.pow(2, power) - n;
        
        if (difference > 0) {
            int[] placeholderArray = new int[(int) Math.pow(2, power)];
            for (int i = 0; i < n; i++) {
                placeholderArray[i] = A[i];
            }
            for (int i = n; i < placeholderArray.length; i++) {
                placeholderArray[i] = 0;
            }
            A = placeholderArray;
        }
        
        // *Implementing Isabells Technique*
        return isabelsMethodRecursive(A)[0];
    }
    
    /**
     * Do not implicitly call this method, use isabelsMethod(int[] A) to access
     * this method so that the array is setup correctly.
     * @param A array of integers
     * @return sum
     */
    private static int[] isabelsMethodRecursive(int[] A) {
        int[] B = new int[A.length/2];
        
        for (int i = 0; i <= A.length/2-1; i++) {
            B[i] = A[2*i] + A[2*i+1];
        }
        
        if (B.length == 1)
            return B;
        else
            return isabelsMethodRecursive(B);
    }
}
