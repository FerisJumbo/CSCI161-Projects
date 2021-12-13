package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.TimingTest;

/**
 * Client Class
 * @author Cole Gartner
 */
public class Client {

    /**
     * Main Method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int amt = 200000000;
            generateRandomValueFile(amt);
            ExternalSort.mergeSortFile("C:/Data/data.txt", "C:/Data/sortedData.txt", amt);
            System.out.println("Is Sorted? | "+ExternalSort.isSorted("C:/Data/sortedData.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Generates a sudorandom list of numbers from 1-amt inclusive and saves it
     * to a file.
     * @param amt amt
     */
    public static void generateRandomValueFile(int amt) {
        TimingTest timer = new TimingTest();
        
        timer.startTimer();
        
        try {
            File file = new File("C:/Data/data.txt");
            if (file.createNewFile()) {
                System.out.println("Created file C:/Data/data.txt");
            }
            
            FileOutputStream fos = new FileOutputStream("C:/Data/data.txt", false);
            PrintWriter pw = new PrintWriter(fos);
            
            Random rnd = new Random();
            for (int i = 0; i < amt; i++) {
                pw.println(rnd.nextInt());
            }
            
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(String.format("Time to make %,d integers: %,.2f milliseconds.", amt, timer.stopTimer()/1e6));
        
    }
    
}
