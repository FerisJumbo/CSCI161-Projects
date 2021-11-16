package program;

import java.util.Random;

/**
 * Holds a students information based on id, name, standing and gpa.
 *
 * @author Cole Gartner
 * @version Nov 11, 2021
 */
public class Student {
    
    /** id distribution */
    private static int[] idDist;
    /** standing distribution */
    private static String[] standingDist;
    /** gpa distribution */
    private static double[] gpaDist;
    /** max amount of students */
    private static final int maxStudents = 1000000;
    /** current amount of students */
    private static int amtOfStudents = 0;
    
    private int id;
    private String lname = "";
    private String fname = "";
    private String standing;
    private double gpa;
    
    
    private boolean isInitialized = false;
    
    /**
     * Creates a new random student.
     */
    public Student () throws IllegalStateException {
        if (!isInitialized) { Initialize(); isInitialized = true; }
        
        if (amtOfStudents >= maxStudents)
            throw new IllegalStateException("Cannot create more than " + maxStudents + " Students");
        
        Random rnd = new Random();
        
        int idIndex = rnd.nextInt(idDist.length);
        while (true) {
            if (idDist[idIndex] == -1) idIndex = (idIndex + 1) % (idDist.length-1);
            else {
                id = idDist[idIndex];
                break;
            }
        }
        idDist[idIndex] = -1;
        
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        lname += String.valueOf(alphabet[rnd.nextInt(alphabet.length)]).toUpperCase();
        for (int r = 1; r < rnd.nextInt(6)+10; r++) {
            lname += alphabet[rnd.nextInt(alphabet.length)];
        }
        fname += String.valueOf(alphabet[rnd.nextInt(alphabet.length)]).toUpperCase();
        for (int r = 1; r < rnd.nextInt(6)+5; r++) {
            fname += alphabet[rnd.nextInt(alphabet.length)];
        }
        
        int standingIndex = rnd.nextInt(standingDist.length);
        while (true) {
            if (standingDist[standingIndex] == "") standingIndex = (standingIndex + 1) % (standingDist.length-1);
            else {
                standing = standingDist[standingIndex];
                break;
            }
        }
        standingDist[standingIndex] = "";
        
        int gpaIndex = rnd.nextInt(gpaDist.length);
        while (true) {
            if (gpaDist[gpaIndex] == -1.0) gpaIndex = (gpaIndex + 1) % (gpaDist.length-1);
            else {
                gpa = gpaDist[gpaIndex];
                break;
            }
        }
        gpaDist[gpaIndex] = -1.0;
        
        amtOfStudents++;
    }
    
    /**
     * Initialize the static distribution variables.
     */
    private void Initialize() {
        idDist = new int[maxStudents];
        standingDist = new String[maxStudents];
        gpaDist = new double[maxStudents];
        
        // Initializing id Distribution
        for (int i = 0; i < idDist.length; i++)
            idDist[i] = i;
        
        // Initializing standing Distribution
        for (int i = 0; i < standingDist.length * 0.1; i++)
            standingDist[i] = "Senior";
        for (int i = (int) (standingDist.length * 0.1); i < standingDist.length * 0.3; i++)
            standingDist[i] = "Junior";
        for (int i = (int) (standingDist.length * 0.3); i < standingDist.length * 0.6; i++)
            standingDist[i] = "Sophmore";
        for (int i = (int) (standingDist.length * 0.6); i < standingDist.length; i++)
            standingDist[i] = "Freshman";
        
        // Initializing gpa Distribution
        for (int i = 0; i < gpaDist.length * 0.05; i++)
            gpaDist[i] = 4.00;
        Random rnd = new Random();
        for (int i = (int) (gpaDist.length * 0.05); i < gpaDist.length * 0.25; i++)
            gpaDist[i] = Math.floor((rnd.nextDouble() + 3.00) * 100)/100;
        for (int i = (int) (gpaDist.length * 0.25); i < gpaDist.length * 0.75; i++)
            gpaDist[i] = Math.floor((rnd.nextDouble() + 2.00) * 100)/100;
        for (int i = (int) (gpaDist.length * 0.75); i < gpaDist.length * 0.95; i++)
            gpaDist[i] = Math.floor((rnd.nextDouble() + 1.00) * 100)/100;
        for (int i = (int) (gpaDist.length * 0.95); i < gpaDist.length; i++)
            gpaDist[i] = Math.floor(rnd.nextDouble()*100)/100;
    }

    /**
     * To String method.
     * @return toString
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + id + ":" + fname + ":" + lname + ":" + standing + ":" + gpa;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @return the standing
     */
    public String getStanding() {
        return standing;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }
    
    
    
}
