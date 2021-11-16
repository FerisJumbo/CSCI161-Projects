package program;

import lib.LinkedQueue;
import lib.TablePrint;
import lib.TimingTest;

/**
 * Client Class holds the main method
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class Client {

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Population of sorting lists
        int maxStuds = 20000;
        Student[] mergeStudList = new Student[maxStuds];
        Student[] bubbleStudList = new Student[Math.min(maxStuds, 100000)];
        Student[] eBubbleStudList = new Student[Math.min(maxStuds, 100000)];
        Student[] selectionStudList = new Student[Math.min(maxStuds, 100000)];
        Student[] insertionStudList = new Student[Math.min(maxStuds, 100000)];
        Student[] radixStudList = new Student[maxStuds];
        
        LinkedQueue<Student> quickStudList = new LinkedQueue<>();
        
        System.out.println("[INFO] Populating Arrays");
        for (int i = 0; i < maxStuds; i++) {
            Student stud = new Student();
            int percent = (int) ((i+1.0)/maxStuds*100);
            System.out.println("[INFO] Adding...  ["+percent+"% | "+(i+1)+"/"+maxStuds+"] " + stud);
            if (i < 100000) {
                bubbleStudList[i] = stud;
                eBubbleStudList[i] = stud;
                selectionStudList[i] = stud;
                insertionStudList[i] = stud;
                radixStudList[i] = stud;
            }
            mergeStudList[i] = stud;
            quickStudList.enqueue(stud);
        }
        
        TablePrint table = new TablePrint("Sorting Algorithms", "Algorithm", "N", "Time (ms)");
        String[] sorts = {"Merge", "Quick", "Bubble", "Efficient Bubble", "Insertion", "Selection", "Radix"};
        String[] n = {"1,000,000", "1,000,000", "100,000", "100,000", "100,000", "100,000", "1,000,000"};
        String[] time = {"", "", "", "", "", "", ""};
        
        TimingTest timer = new TimingTest();
        
        // Merge Sort
        System.out.println("[INFO] Starting Merge Sort...");
        timer.startTimer();
        
        Sort.mergeSort(mergeStudList, new IDComparator());
        
        time[0] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Merge Sort Complete");
        
        // Quick Sort
        System.out.println("[INFO] Starting Quick Sort...");
        timer.startTimer();
        
        Sort.quickSort(quickStudList, new GPAComparator());
        
        time[1] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Quick Sort Complete");
        
        // Bubble Sort
        System.out.println("[INFO] Starting Bubble Sort...");
        timer.startTimer();
        
        Sort.bubbleSort(bubbleStudList, new IDComparator());
        
        time[2] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Bubble Sort Complete");
        
        // Efficient Bubble Sort
        System.out.println("[INFO] Starting Efficient Bubble Sort...");
        timer.startTimer();
        
        Sort.efficientBubbleSort(eBubbleStudList, new IDComparator());
        
        time[3] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Efficient Bubble Sort Complete");
        
        // Insertion Sort
        System.out.println("[INFO] Starting Insertion Sort...");
        timer.startTimer();
        
        Sort.insertionSort(insertionStudList, new GPAComparator());
        
        time[4] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Insertion Sort Complete");
        
        // Selection Sort
        System.out.println("[INFO] Starting Selection Sort...");
        timer.startTimer();
        
        Sort.selectionSort(selectionStudList, new StandingComparator());
        
        time[5] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Selection Sort Complete");
        
        // Radix Sort
        System.out.println("[INFO] Starting Radix Sort...");
        timer.startTimer();
        
        Sort.radixSort(radixStudList, new StandingComparator(), new GPAComparator(),
                new LastNameComparator(), new FirstNameComparator(), null);
        
        time[6] = String.valueOf(timer.stopTimer()/1e+6);
        System.out.println("[INFO] Radix Sort Complete");
        
        
        for (int i = 0; i < time.length; i++) {
            double dubTime = Double.parseDouble(time[i]);
            int intTime = (int) Math.floor(dubTime);
            String parsedString = String.format("%,d", intTime);
            time[i] = parsedString;
        }
        
        
        System.out.println(table.print(sorts, n, time));
        
    }
    
}
