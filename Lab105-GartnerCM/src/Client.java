
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * Holds the main method.
 * @author Cole Gartner
 */
public class Client {
    
    /** Keyboard input. */
    private static Scanner keyInput = new Scanner(System.in);

    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu("-m");
    }
    
    /**
     * Holds the menu to select different recursive functions.
     * @param arg argument
     */
    private static void menu(String arg) {
        // Main menu
        if (arg.equals("-m")) {
            System.out.println("""
                                  Lab105-GartnerCM 
                               ----------------------
                               1:Harmonic Summation
                               2:Isabels Technique
                               3:File Finder
                               
                               Q:Quit
                                   """);
            System.out.print("> ");
            String input = keyInput.nextLine();
            if (input.equals("1")) menu("-1");
            else if (input.equals("2")) menu("-2");
            else if (input.equals("3")) menu("-3");
            else if (input.equals("q")) menu("-q");
            else {
                System.out.println("Please put a valid input\n\n");
                menu("-m");
            }
            
        }
        
        // Harmonic Sum
        if (arg.equals("-1")) {
            System.out.println("""
                                      Harmonic Summation
                               --------------------------------
                               Please input a positive integer
                               or
                               q to quit
                               """);
            System.out.print("> ");
            String input = keyInput.nextLine();
            if (input.equals("q")) menu("-m");
            else {
                try {
                    if (Integer.parseInt(input) > 0) {
                        System.out.println("Sum: " + Recursive.harmonic(Integer.parseInt(input)));
                        menu("-1");
                    }
                } catch (Exception e) {
                    System.out.println("Please put a valid input\n\n");
                    menu("-1");
                }
            }
        }
        
        // Isabels Technique
        if (arg.equals("-2")) {
            System.out.println("""
                                        Isabels Techinque
                               -----------------------------------
                               Please type the absolute path to a
                               .txt file that includes integers
                               or
                               q to quit
                               """);
            System.out.print("> ");
            String input = keyInput.nextLine();
            if (input.equals("q")) menu("-m");
            else {
                try {
                    int sum = Recursive.isabelsMethod(Recursive.fileToIntArray(input));
                    System.out.println("Sum: " + sum);
                    menu("-2");
                } catch (FileNotFoundException ex) {
                    System.out.println("Please put a valid file location\n\n");
                    menu("-2");
                }
            }
        }
        
        // File Finder
        if (arg.equals("-3")) {
            System.out.println("""
                                           File Finder
                               -----------------------------------
                               Please type a targetfile.extension
                               and press enter then type the start
                               absolute path as a point of
                               insertion
                               or
                               q to quit
                               """);
            System.out.print("Target File > ");
            String targetFile = keyInput.nextLine();
            if (targetFile.equals("q")) menu("-m");
            else {
                System.out.print("Start Path > ");
                String startPath = keyInput.nextLine();
                try {
                    Recursive.findFile(targetFile, startPath);
                    menu("-3");
                } catch (IllegalArgumentException e) {
                    System.out.println("Please put a valid start path\n\n");
                    menu("-3");
                } catch (Exception e) {
                    System.out.println("There was an unexpected error while searching\n\n");
                    menu("-3");
                }
            }
        }
        
        // Ends the program
        if (arg.equals("-q")) { }
    }
    
}
