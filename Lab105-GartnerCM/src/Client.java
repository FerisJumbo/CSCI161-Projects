
import java.io.FileNotFoundException;

/**
 * Holds the main method.
 * @author Cole Gartner
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = new int[1];
        try {
            A = Recursive.fileToIntArray("D:\\System\\Desktop\\ArrayMe.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(Recursive.isabelsMethod(A));
    }
    
}
