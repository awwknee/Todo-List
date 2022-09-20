import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Creates a class TodoList that creates a TodoList from the user input of a username. If the
 * username is on file it opens the existing TodoLIST and adds to it.
 * 
 * @author Ani Lamichhane
 *
 */
public class TodoList {
    /**
     * ArrayList of TodoItem that holds theTasks.
     */
    private ArrayList<TodoItem> theTasks;
    /**
     * String that holds the username.
     */
    private String username;

    /**
     * Constructor that initializes the ArrayList and the username.
     * 
     * @param username String that holds the username.
     */
    public TodoList(String username) {
        theTasks = new ArrayList<TodoItem>();
        this.username = username;
    }

    /**
     * A public static factory method that takes in the username and gets the TodoList associated
     * with the username, if it doesn't exist it creates a new TodoList. Also has error checking.
     * 
     * @param username String that holds the username.
     * @return TodoList for the username.
     */
    public static TodoList buildFromUsername(String username) {
        TodoList theTodoList = new TodoList(username);
        List<String> theLines;

        try {
            theLines = Files.readAllLines(Paths.get(username + ".txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < theLines.size(); i++) {
            TodoItem todoItem = TodoItem.buildFromCSV(theLines.get(i));
            theTodoList.addTask(todoItem);
        }
        return theTodoList;

    }

    /**
     * A method that adds the toDolist to the Array of tasks.
     * 
     * @param item a Todolist
     */
    public void addTask(TodoItem item) {
        theTasks.add(item);

    }

    /**
     * A method that sorts the tasks by date.
     * 
     * @return String "No tasks in list." if the Array is empty and the whole array formated if
     *         there are tasks in the Array,
     */
    public String getAsDateSortedString() {
        String dateSorted;
        if (theTasks.size() == 0) {
            return "No tasks in list.";
        }

        Comparator<TodoItem> comparisonBox = new DateComparator();
        theTasks.sort(comparisonBox);

        dateSorted = "\n";

        for (int i = 0; i < theTasks.size(); i++) {
            dateSorted = dateSorted + "* \n";
            dateSorted = dateSorted + "Date: " + theTasks.get(i).getDate() + "\n";
            dateSorted = dateSorted + "Importance: " + theTasks.get(i).getImportanceLevel() + "\n";
            dateSorted = dateSorted + theTasks.get(i).getDescription() + "\n" + "\n";

        }

        return dateSorted;

    }

    /**
     * A method that sorts the tasks by importance level.
     * 
     * @return String "No tasks in list." if the Array is empty and the whole array formated if
     *         there are tasks in the Array,
     */
    public String getAsImportanceSortedString() {
        String importanceSorted;

        if (theTasks.size() == 0) {
            return "No tasks in list.";
        }

        Comparator<TodoItem> comparisonBox = new ImportanceComparator();
        theTasks.sort(comparisonBox);

        importanceSorted = "\n";

        for (int i = 0; i < theTasks.size(); i++) {
            importanceSorted = importanceSorted + "* \n";
            importanceSorted = importanceSorted + "Date: " + theTasks.get(i).getDate() + "\n";
            importanceSorted =
                    importanceSorted + "Importance: " + theTasks.get(i).getImportanceLevel() + "\n";
            importanceSorted = importanceSorted + theTasks.get(i).getDescription() + "\n" + "\n";
        }
        return importanceSorted;
    }

    /**
     * A method that writes a file with the tasks for the user. Also has error checking.
     */
    public void finalize() {
        String toWrite = "";
        for (TodoItem item : theTasks) {
            toWrite = toWrite + item.getAsCSV() + "\n";
        }

        try {
            Files.write(Paths.get(username + ".txt"), toWrite.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
