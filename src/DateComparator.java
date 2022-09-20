import java.util.Comparator;

/**
 * A Comparator that compares Dates in a TodoItem.
 * 
 * @author Ani Lamichhane
 *
 */
public class DateComparator implements Comparator<TodoItem> {

    /**
     * A method that creates a comparator that is used to compare Dates.
     * 
     * @return int 1 if this > other, -1 if this < other, 0 if this = other.
     */
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
