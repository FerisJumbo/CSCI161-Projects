package program;


/**
 * Compares two students based on Standing.
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class StandingComparator implements Comparator<Student> {

    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Student a, Student b) {
        int aStand = 0;
        int bStand = 0;
        switch (a.getStanding()) {
            case "Freshman" -> aStand = 0;
            case "Sophmore" -> aStand = 1;
            case "Junior" -> aStand = 2;
            case "Senior" -> aStand = 3;
        }
        switch (b.getStanding()) {
            case "Freshman" -> bStand = 0;
            case "Sophmore" -> bStand = 1;
            case "Junior" -> bStand = 2;
            case "Senior" -> bStand = 3;
        }
        if (aStand > bStand) return -1;
        else if (aStand == bStand) return 0;
        else return 1;
    }
}
