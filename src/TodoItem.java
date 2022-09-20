/**
 * Creates a class TodoItem that creates a TodoItem from a date, description and importanceLevel
 * from comma separated variables.
 * 
 * @author Ani Lamichhane
 *
 */
public class TodoItem {
    /**
     * Date that holds the date.
     */
    private Date date;

    /**
     * String that holds the description.
     */
    private String description;

    /**
     * Importance that holds the importanceLevel.
     */
    private Importance importanceLevel;

    /**
     * Constructor that initializes date, description and importanceLevel.
     * 
     * @param date Date that holds the date.
     * @param description String that holds the description.
     * @param importanceLevel Importance that holds the importanceLevel.
     */
    public TodoItem(Date date, String description, Importance importanceLevel) {
        this.date = date;
        this.description = description;
        this.importanceLevel = importanceLevel;

    }

    /**
     * A public static factory method that creates a new TodoItem from a string of comma separated
     * variables. Also error checks.
     * 
     * @param csv String of comma separated variables.
     * @return a new TodoItem with the date, description and importanceLevel from the csv.
     */
    public static TodoItem buildFromCSV(String csv) {
        String[] item = csv.split(",");

        Date date = Date.fromYYYYMMDDString(item[0]);
        String description = item[1];

        if (description.contains(",")) {
            throw new IllegalArgumentException();
        }

        Importance importanceLevel;

        try {
            importanceLevel = Importance.valueOf(item[2]);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        return new TodoItem(date, description, importanceLevel);

    }

    /**
     * Method that returns date, description and importanceLevel as a csv.
     * 
     * @return String of comma separated variables.
     */
    public String getAsCSV() {
        return "" + date.getAsYYYYMMDD() + "," + description + "," + importanceLevel;

    }

    /**
     * Method that returns the date.
     * 
     * @return Date
     */
    public Date getDate() {
        return date;

    }

    /**
     * Method that returns importanceLevel.
     * 
     * @return importanceLevel
     */
    public Importance getImportanceLevel() {
        return importanceLevel;

    }

    /**
     * Method that returns description.
     * 
     * @return description
     */
    public String getDescription() {
        return description;

    }
}
