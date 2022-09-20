import java.util.Comparator;

/**
 * A Comparator that compares Importance Levels in a TodoItem.
 * 
 * @author Ani Lamichhane
 *
 */
public class ImportanceComparator implements Comparator<TodoItem> {
    /**
     * A method that creates a comparator that is used to compare Importance Levels.
     * 
     * @return int 1 if this > other, -1 if this < other, 0 if this = other.
     */
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        if ((o1.getImportanceLevel().compareTo(o2.getImportanceLevel())) > 0) {
            return 1;
        } else if ((o1.getImportanceLevel().compareTo(o2.getImportanceLevel())) < 0) {
            return -1;
        } else {
            return 0;

        }
    }
}

