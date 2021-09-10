
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Client class that holds interface systems to the user and logic for
 * printing out quotes from a txt file.
 *
 * @author Cole Gartner
 * @version Sep 09, 2021
 */
public class Client {
    
    /**
     * Main method
     * @param args arguments
     * @throws FileNotFoundException File not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        // Part 1
        
        Scanner keyboard = new Scanner(System.in);
        File dataFile = new File("");
        
        while (true) {
            System.out.print("What is the file path to data.txt?\n> ");
            String path = keyboard.nextLine();
            
//            // Used to quickly test the project on local machine
//            if (path.equals("test")) {
//                path = "D:/System/Downloads/Lab102Data.txt";
//                System.out.println("Using test directory | " + path);
//            }
            
            dataFile = new File(path);
            
            if (dataFile.exists()) {
                keyboard.close();
                break;
            }
            
            System.out.println("\nThat file doesn't exist!\n\n");
        }
        
        
        // Part 2
        
        
        Scanner fileScan = new Scanner(dataFile);
        fileScan.useDelimiter("\n");
        
        // Counting how many times file is iterated through scanner
        int rows = 0;
        while (fileScan.hasNext()) {
            rows++;
            fileScan.next();
        }
        
        fileScan.close();
        
        
        // Part 3
        
        
        Quote[] quotes = new Quote[rows];
        
        
        // Part 4
        
        
        fileScan = new Scanner(dataFile); // Resets scanner
        fileScan.useDelimiter("\n");
        
        for (int i = 0; i < quotes.length; i++) {
            // Gets the next line in data.txt
            String quoteLong = fileScan.next();
            Scanner quoteScan = new Scanner(quoteLong);
            quoteScan.useDelimiter(",");
            
            Quote newQuote = new Quote(quoteScan.next(), quoteScan.next(),
                    quoteScan.nextDouble(), quoteScan.nextDouble(),
                    quoteScan.nextDouble(), quoteScan.nextDouble(),
                    Integer.parseInt(quoteScan.next().split("\r")[0]));
            // quoteScan.nextInt() needs to remove a pesky "\r" that was taken
            // from the long String.
            
            quotes[i] = newQuote;
            quoteScan.close();
        }
        
        
        // Part 5
        
        
        ArrayList<Quote> bigGain = new ArrayList<Quote>(); double gainAmt = Integer.MIN_VALUE;
        ArrayList<Quote> bigLoss = new ArrayList<Quote>(); double lossAmt = Integer.MAX_VALUE;
        ArrayList<Quote> mostVol = new ArrayList<Quote>(); int volAmt = Integer.MIN_VALUE;
        
        for(Quote q : quotes) {
            // Testing for largest gain
            if (q.margin() == gainAmt) {
                bigGain.add(q);
            } else if (q.margin() > gainAmt) {
                bigGain = new ArrayList<Quote>();
                bigGain.add(q);
                gainAmt = q.margin();
            
            // Testing for largest loss
            } else if (q.margin() == lossAmt) {
                bigLoss.add(q);
            } else if (q.margin() < lossAmt) {
                bigLoss = new ArrayList<Quote>();
                bigLoss.add(q);
                lossAmt = q.margin();
                
            // Testing for most volume traded
            } else if (q.getVol() == volAmt) {
                mostVol.add(q);
            } else if (q.getVol() > volAmt) {
                mostVol = new ArrayList<Quote>();
                mostVol.add(q);
                volAmt = q.getVol();
            }
        }
        
        System.out.printf("\n\nBiggest Gainers\t\t Gain: %1.2f\n", gainAmt);
        for (Quote q : bigGain) { System.out.println(q.getTicker()); }
        System.out.printf("\n\nBiggest Losers\t\t Loss: %1.2f\n", lossAmt);
        for (Quote q : bigLoss) { System.out.println(q.getTicker()); }
        System.out.printf("\n\nMost Traded\t\t Traded: %,-10d\n", volAmt);
        for (Quote q : mostVol) { System.out.println(q.getTicker()); }
        
        
        // Part 6
        
        
        System.out.println("\n\nPrinting first 25 quotes\n");
        
        System.out.printf("%s\t%s\t%16s\t%8s\t%8s\t%8s\t%12s\n",
                "Ticker", "Date", "Open", "High", "Low", "Close", "Volume");
        System.out.println("---------------------------------------------------"
                           + "-------------------------------------------------");
        for (int i = 0; i < 25; i++) {
            formattedPrintQuote(quotes[i]);
        }
        
        
//        // Extra testing of formattedPrintQuote
//        
//        
//        System.out.println("\n\nFull List\n");
//        
//        System.out.printf("%s\t%s\t%16s\t%8s\t%8s\t%8s\t%12s\n",
//                "Ticker", "Date", "Open", "High", "Low", "Close", "Volume");
//        System.out.println("---------------------------------------------------"
//                           + "-------------------------------------------------");
//        for (Quote q : quotes) {
//            formattedPrintQuote(q);
//        }
        
    }
    
    /**
     * Prints out quotes in a formatted way
     * Used mostly for Part 6
     * @param q quote
     */
    public static void formattedPrintQuote(Quote q) {
        System.out.printf("%-5s\t%8d\t%8.2f\t%8.2f\t%8.2f\t%8.2f\t%,12d\n",
                q.getTicker(), Integer.parseInt(q.getDate()), q.getOpen(),
                q.getHigh(), q.getLow(), q.getClose(), q.getVol());
    }
}
