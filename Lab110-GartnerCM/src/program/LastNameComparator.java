package program;

/**
 * Compares students last names.
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class LastNameComparator implements Comparator<Student> {
/**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Student a, Student b) {
        String lastA = a.getLname();
        String lastB = b.getLname();
        if (lastA.compareTo(lastB) > 0)
            return -1;
        else if (lastA.compareTo(lastB) == 0)
            return 0;
        else
            return 1;
    }
    
}
