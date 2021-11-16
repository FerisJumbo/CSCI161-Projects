package program;

/**
 * Compares Students first names
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class FirstNameComparator implements Comparator<Student> {

    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Student a, Student b) {
        String firstA = a.getFname();
        String firstB = b.getFname();
        if (firstA.compareTo(firstB) > 0)
            return -1;
        else if (firstA.compareTo(firstB) == 0)
            return 0;
        else
            return 1;
    }
    
}
