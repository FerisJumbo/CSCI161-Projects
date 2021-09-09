
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Description of Client
 *
 * @author Cole Gartner
 * @version Sep 09, 2021
 */
public class Client {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String filePath = "";
        
        // Part 1
        
        File file = new File("");
        
        // Tests to make sure the file path given exists
        while (true) {
            System.out.print("What is the absolute file path to the data text file?\n> ");
            // Testing file path -> D:/System/Downloads/Lab102Data.txt
            
            filePath = in.nextLine();
            file = new File(filePath);
            
            if (file.exists())
                break;
            
            System.out.println("\nError!  File Path doesn't exist! Please try again.\n\n");
        }
        
        // Part 2
        
        
        Scanner fileScan = new Scanner("");
        
        fileScan = new Scanner(file);
        
        fileScan.useDelimiter("\n");
        
        // Counting throughout the File to get array size
        int count = 0;
        while (fileScan.hasNext()) {
            fileScan.next();
            count++;
        }
        
        // Part 3
        
        Quote[] quotes = new Quote[count];
        
        // Part 4
        
        fileScan = new Scanner(file); // Resets scanner
        fileScan.useDelimiter("\n");
        
        count = 0;
        while (fileScan.hasNext()) {
            String quote = fileScan.next();
            
            Scanner quoteScan = new Scanner(quote);
            quoteScan.useDelimiter(",");
            
            String ticker = quoteScan.next();
            String date = quoteScan.next();
            double open = quoteScan.nextDouble();
            double high = quoteScan.nextDouble();
            double low = quoteScan.nextDouble();
            double close = quoteScan.nextDouble();
            // Need to modify last line to remove pesky \r that is inside quote object at the end
            int vol = Integer.parseInt(quoteScan.next().split("\r")[0]);
            
            Quote newQuote = new Quote(ticker, date, open, high, low, close, vol);
            
            quotes[count] = newQuote;
            
            count++;
        }
        
        // Part 5
        
        Quote biggestGain = new Quote();
        double gainAmt = 0;
        Quote biggestLosser = new Quote();
        double lossAmt = 0;
        Quote highestVol = new Quote();
        int volHigh = 0;
        for (Quote q : quotes) {
            if ((q.getClose() - q.getOpen()) > gainAmt) {
                biggestGain = q;
                gainAmt = (q.getClose() - q.getOpen());
            }
            if ((q.getOpen() - q.getClose()) > gainAmt) {
                biggestLosser = q;
                lossAmt = (q.getOpen() - q.getClose());
            }
            if (q.getVol() > volHigh) {
                highestVol = q;
                volHigh = q.getVol();
            }
        }
        
        System.out.println(biggestGain.getTicker() + "\nGain: " + Math.floor(gainAmt * 100) / 100);
        System.out.println(biggestLosser.getTicker() + "\nLoss: " + Math.floor(lossAmt * 100) / 100);
        System.out.println(highestVol.getTicker() + "\nVolume: " + volHigh);
    }
    
}
