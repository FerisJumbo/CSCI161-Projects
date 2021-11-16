package program;

/**
 * Compares GPA's of students.
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class GPAComparator implements Comparator<Student> {

    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Student a, Student b) {
        if (a.getGpa() > b.getGpa()) return -1;
        else if (a.getGpa() == b.getGpa()) return 0;
        else return 1;
    }
}
