package program;


/**
 * Compares Id's of Students.
 *
 * @author Cole Gartner
 * @version Nov 15, 2021
 */
public class IDComparator implements Comparator<Student> {

    /**
     * Compares two Objects and returns either -1, 0, 1.
     * @param a obj1
     * @param b obj2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Student a, Student b) {
        if (a.getId() < b.getId()) return -1;
        else if (a.getId() == b.getId()) return 0;
        else return 1;
    }
    
}
