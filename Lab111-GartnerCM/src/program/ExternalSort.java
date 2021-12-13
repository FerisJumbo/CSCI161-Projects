package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import lib.MergeSort;
import lib.TimingTest;

/**
 * Description of ExternalSort
 *
 * @author Cole Gartner
 * @version Nov 28, 2021
 */
public class ExternalSort {
    
    /**
     * Sorts a file by merge sort and by blocking the file into sections to sort
     * @param unsortedFile path to unsorted file.
     * @param sortedFile path to sorted file (empty).
     * @param amt amount
     * @throws java.io.FileNotFoundException FileNotFoundException
     * @throws java.io.IOException IOException
     */
    public static void mergeSortFile(String unsortedFile, String sortedFile, int amt) throws FileNotFoundException, IOException {
        File unsorted = new File(unsortedFile);
        Scanner fileScan = new Scanner(unsorted);
        
        double[] timings = new double[3];
        
        // Count of lines
//        int amt = 200000000;
//        while (fileScan.hasNext()) {
//            amt++;
//            fileScan.nextLine();
//        }
        
        //Logical Spliting
        int amtPerGroup = amt;
        int groups = 1;
        while (amtPerGroup > 100000 || groups < 10) { // With a size of 200M, and less than 100K in each group, there is 12 groups.
            amtPerGroup /= 2;
            groups++;
        }
        
        // Reset Scanner
        fileScan = new Scanner(unsorted);
        
        String[] groupFileNames = new String[groups];
        
        TimingTest timer = new TimingTest();
        
        timer.startTimer();
        for (int i = 1; i <= groups; i++) {
            groupFileNames[i-1] = ""+i;
            String fileName = "C:/Data/group"+i+".txt";
            File newGroup = new File(fileName);
            newGroup.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(fileName, false);
            PrintWriter pw = new PrintWriter(fos);
            
            for (int j = 0; j < amt/groups; j++) {
                pw.println(fileScan.nextLine());
            }
            
            pw.close();
        }
        fileScan.close();
        timings[0] = timer.stopTimer()/1e6;
        System.out.println(String.format("Time to split into %d blocks: %,.2f milliseconds.", groups, timings[0]));
        
        // Sorting Groups
        timer.startTimer();
        for (int i = 1; i <= groups; i++) {
            String fileName = "C:/Data/group"+i+".txt";
            Scanner groupFileScan = new Scanner(new File(fileName));
            Integer[] intArray = new Integer[amt/groups];
            
            int j = 0;
            while (groupFileScan.hasNext()) {
                intArray[j] = Integer.parseInt(groupFileScan.nextLine());
                j++;
            }
            
            groupFileScan.close();
            MergeSort.sort(intArray, new IntegerComparator());
            
            FileOutputStream fos = new FileOutputStream(fileName, false);
            PrintWriter pw = new PrintWriter(fos);
            
            for (Integer integer : intArray)
                pw.println(integer);
                        
            pw.close();
        }
        timings[1] = timer.stopTimer()/1e6;
        System.out.println(String.format("Time to sort blocks: %,.2f milliseconds.", timings[1]));
        
        // Merging Group Files
        timer.startTimer();
        while (groupFileNames.length > 1) {
            if (groupFileNames.length % 2 == 1) { // if odd grouping
                String[] tempNames = new String[groupFileNames.length-1];
                tempNames[tempNames.length-1] = mergeGroups(groupFileNames[groupFileNames.length-2], groupFileNames[groupFileNames.length-1]);
                for (int i = 0; i < tempNames.length-1; i++) { // copy array
                    tempNames[i] = groupFileNames[i];
                }
                groupFileNames = tempNames;
            } else { // if even grouping 
                String[] tempNames = new String[groupFileNames.length/2];
                for (int i = 0; i < groupFileNames.length/2; i++) {
                    tempNames[i] = mergeGroups(groupFileNames[i*2], groupFileNames[i*2+1]);
                }
                groupFileNames = tempNames;
            }
        }
        timings[2] = timer.stopTimer()/1e6;
        System.out.println(String.format("Time to merge %d blocks: %,.2f milliseconds.", groups, timings[2]));
        
        File sorted = new File("C:/Data/group"+groupFileNames[0]+".txt");
        if (new File(sortedFile).exists()) {
            new File(sortedFile).delete();
        }
        
        sorted.renameTo(new File(sortedFile));
        System.out.println(String.format("Total external merge sort time: %,.2f milliseconds", timings[0]+timings[1]+timings[2]));
    }
    
    /**
     * Merges two files together into one file.
     * @param G1 Group 1
     * @param G2 Group 2
     * @return String name of new File
     * @throws java.io.FileNotFoundException 
     */
    private static String mergeGroups(String G1, String G2) throws FileNotFoundException {
        File file1 = new File("C:/Data/group"+G1+".txt");
        File file2 = new File("C:/Data/group"+G2+".txt");
        
        Scanner group1 = new Scanner(file1);
        Scanner group2 = new Scanner(file2);
        
        FileOutputStream fos = new FileOutputStream("C:/Data/group"+G1+"-"+G2+".txt", false);
        PrintWriter pw = new PrintWriter(fos);

        int val1 = Integer.parseInt(group1.nextLine());
        int val2 = Integer.parseInt(group2.nextLine());
        
        while(group1.hasNext() && group2.hasNext()) {
            if (new IntegerComparator().compare(val1, val2) < 0) {
                pw.println(val1);
                val1 = group1.nextInt();
            } else {
                pw.println(val2);
                val2 = group2.nextInt();
            }
        }
        if (new IntegerComparator().compare(val1, val2) < 0) {
            pw.println(val1);
            pw.println(val2);
        } else {
            pw.println(val2);
            pw.println(val1);
        }
        while (group1.hasNext() == true) {
            String next = group1.nextLine();
            if (next == "")
                continue;
            else {
                pw.println(Integer.parseInt(next));
            }
        }
        while (group2.hasNext() == true) {
            String next = group2.nextLine();
            if (next == "")
                continue;
            else {
                pw.println(Integer.parseInt(next));
            }
        }

        pw.close();
        
        group1.close();
        group2.close();
        
        file1.delete(); // Storage Clean up
        file2.delete(); // Storage Clean up
        
        return G1+"-"+G2;
    }
    
    /**
     * Checks to see if the file is sorted.
     * @param filepath filepath
     * @return isSorted
     * @throws java.io.FileNotFoundException FileNotFoundException
     */
    public static boolean isSorted(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        
        Scanner fileScan = new Scanner(file);
        
        int prev = Integer.MIN_VALUE;
        while (fileScan.hasNext()) {
            String curr = fileScan.nextLine();
            if (curr == "") continue;
            if (prev > Integer.parseInt(curr)) {
                return false;
            }
        }
        return true;
    }
}
