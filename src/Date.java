
/**
 * Creates a class Date that implements a comparable Date. Can convert strings to Dates and have
 * error checking.
 * 
 * @author Ani Lamichhane
 *
 */
public class Date implements Comparable<Date> {

    /**
     * An int that holds the month.
     */
    private int month;

    /**
     * An int that holds the day.
     */
    private int day;

    /**
     * An int that holds the year.
     */
    private int year;

    /**
     * Constructor that initializes month, day and year.
     * 
     * @param month An int that holds the month.
     * @param day An int that holds the day.
     * @param year An int that holds the year.
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;

    }

    /**
     * A public static factory method that takes in user input of a String and converts it to a
     * Date. Also has error checking.
     * 
     * @param date user input of a String that holds the date.
     * @return Date with the month, day and year from the user input.
     */
    public static Date fromYYYYMMDDString(String date) {
        int year;
        int month;
        int day;

        String[] mydate = date.split("");

        if (mydate.length != 8) {
            throw new IllegalArgumentException();
        }

        try {
            year = Integer.parseInt("" + mydate[0] + mydate[1] + mydate[2] + mydate[3]);

            month = Integer.parseInt("" + mydate[4] + mydate[5]);

            day = Integer.parseInt("" + mydate[6] + mydate[7]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (month > 12 || month < 1) {
            throw new IllegalArgumentException();
        }

        if (month == 1 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 2 && day > 29) {
            throw new IllegalArgumentException();
        } else if (month == 3 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 4 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 5 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 6 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 7 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 8 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 9 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 10 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 11 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 12 && day > 31) {
            throw new IllegalArgumentException();
        }


        return new Date(month, day, year);

    }

    /**
     * A public static factory method that takes in user input of a String with dashes and converts
     * it to a Date. Also has error checking.
     * 
     * @param date user input of a String that holds the date.
     * @return Date with the month, day and year from the user input.
     */
    public static Date fromYYYYMMDDDashString(String date) {
        int year;
        int month;
        int day;

        String[] mydate = date.split("-");

        if (mydate.length != 3) {
            throw new IllegalArgumentException();
        }

        if (mydate[0].length() != 4 || mydate[1].length() != 2 || mydate[2].length() != 2) {
            throw new IllegalArgumentException();
        }

        try {
            year = Integer.parseInt(mydate[0]);

            month = Integer.parseInt(mydate[1]);

            day = Integer.parseInt(mydate[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (month > 12 || month < 1) {
            throw new IllegalArgumentException();
        }

        if (month == 1 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 2 && day > 29) {
            throw new IllegalArgumentException();
        } else if (month == 3 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 4 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 5 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 6 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 7 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 8 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 9 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 10 && day > 31) {
            throw new IllegalArgumentException();
        } else if (month == 11 && day > 30) {
            throw new IllegalArgumentException();
        } else if (month == 12 && day > 31) {
            throw new IllegalArgumentException();
        }


        return new Date(month, day, year);


    }

    /**
     * A method that uses month, day and year to create and int of the date.
     * 
     * @return int of date in YYYYMMDD format.
     */
    public int getAsYYYYMMDD() {
        String monthString = "" + month;
        String dayString = "" + day;

        if (month < 10) {
            monthString = "0" + month;
        }

        if (day < 10) {
            dayString = "0" + day;
        }

        return Integer.parseInt("" + year + monthString + dayString);

    }

    /**
     * A method that checks if dates are equal.
     * 
     * @return boolean true if dates are equal and false if dates aren't equal.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other.getClass() != this.getClass()) {
            return false;
        }
        Date otherAsDate = (Date) other;
        if (this.month == otherAsDate.month && this.day == otherAsDate.day
                && this.year == otherAsDate.year) {
            return true;
        }
        return false;
    }

    /**
     * A method that overrides compareTo and compares dates to each other.
     * 
     * @return int 1 if this > other, -1 if this < other, 0 if this = other.
     */
    @Override
    public int compareTo(Date other) {
        if (this.year == other.year && this.month == other.month && this.day > other.day) {
            return 1;
        } else if (this.year == other.year && this.month == other.month && this.day < other.day) {
            return -1;
        } else if (this.year == other.year && this.month > other.month) {
            return 1;
        } else if (this.year == other.year && this.month < other.month) {
            return -1;
        } else if (this.year > other.year) {
            return 1;
        } else if (this.year < other.year) {
            return -1;
        } else {
            return 0;
        }

    }

    /**
     * A method that overrides toString that writes the Date in MM/DD/YYYY format.
     * 
     * @return String in MM/DD/YYYY format.
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
