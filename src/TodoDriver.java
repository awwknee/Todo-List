import java.util.Scanner;

/**
 * Creates a Todo List application that allows different users to access their own todo lists, sort
 * tasks by date or importance, and add new tasks. The task data for each user is stored in text
 * files in comma-separated value format. Also handles all possible errors.
 * 
 * @author Ani Lamichhane
 *
 */
public class TodoDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String username;
        TodoList todoList;

        while (true) {
            System.out.print("Enter your username: ");
            username = keyboard.next();

            String[] splitUsername = username.split("");

            try {

                for (int i = 0; i < splitUsername.length; i++) {
                    if (splitUsername[0].equals(".")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[0].equals("-")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[0].equals("_")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[splitUsername.length - 1].equals(".")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[splitUsername.length - 1].equals("-")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[splitUsername.length - 1].equals("_")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("#")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("%")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("{")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("}")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("\\")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("$")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("!")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("'")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("\"")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals(":")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("@")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("<")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals(">")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("*")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("?")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("/")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("`")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("|")) {
                        throw new IllegalArgumentException();
                    } else if (splitUsername[i].equals("=")) {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Username");
                continue;
            }
            break;
        }

        try {
            todoList = TodoList.buildFromUsername(username);
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred trying to read the file for your username.");
            System.out.print("Create new Todo List? (Y/N) ");
            String choice = keyboard.next();
            if (!choice.equals("Y")) {
                return;
            }
            todoList = new TodoList(username);
        }

        while (true) {
            String choice;

            System.out.println("Options:");
            System.out.println("1) Show tasks sorted by date");
            System.out.println("2) Show tasks sorted by importance");
            System.out.println("3) Add new task");
            System.out.println("4) Save and exit");
            System.out.print("Your choice: ");
            choice = keyboard.next();
            if (choice.equals("1")) {
                System.out.println(todoList.getAsDateSortedString());

            } else if (choice.equals("2")) {
                System.out.println(todoList.getAsImportanceSortedString());

            } else if (choice.equals("3")) {
                Date date;
                Importance importance;
                String description;
                String input;
                TodoItem item;


                try {
                    System.out.print("Enter a date (YYYY-MM-DD): ");
                    input = keyboard.next();
                    date = Date.fromYYYYMMDDDashString(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Date");
                    continue;
                }

                try {
                    System.out.print("Enter an importance (HIGH, MEDIUM, LOW): ");
                    input = keyboard.next();
                    importance = Importance.valueOf(input.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Importance Level");
                    continue;
                }

                try {
                    System.out.print("Enter a short description (no commas): ");
                    keyboard.nextLine();
                    input = keyboard.nextLine();

                    if (input.contains(",")) {
                        throw new IllegalArgumentException();
                    }
                    description = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Description");
                    continue;
                }

                item = new TodoItem(date, description, importance);
                todoList.addTask(item);


            } else if (choice.equals("4")) {
                try {
                    todoList.finalize();
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Problem writing file.");
                    return;
                }

            } else {
                System.out.println("Invalid Option");

            }
        }
    }
}
