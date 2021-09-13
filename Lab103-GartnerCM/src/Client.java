
import java.util.Random;

/**
 * Client class is used to hold the Main method.
 * @author Cole Gartner
 * @version Sep 12, 2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Part 1, 2 & 3
        
        
        Scores bag = new Scores(16);
        
        Random rand = new Random();
        for (int i = 0; i < 32; i++) {
            bag.add(rand.nextInt(21) - 10); // Generates random number 0-20 and subratacts 10 to get -10-10
        }
        
        System.out.println(bag);
        
        
        // Part 4 & 5
        
        
        bag.add(7);
        
        System.out.println("Size: " + bag.size());
        
        
        // Part 6, 7, 8, & 9
        
        
        bag.remove();
        
        int twentyFifth = bag.get(25);
        
        System.out.println("25th Index: " + twentyFifth);
        
        System.out.println("Frequency: " + bag.getFrequencyOf(twentyFifth));
        
        
        // Part 10, 11
        
        
        bag.remove(twentyFifth);
        
        System.out.println("Frequency: " + bag.getFrequencyOf(twentyFifth));
        
        // Part 12, 13
        
        System.out.println("Contains 15: " + bag.contains(15));
        
        System.out.println("Capacity: " + bag.capacity());
    }
    
}
