public class Date implements Comparable<Date> {

    private final int month;
    private final int day;
    private final int year;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public int compareTo(Date that) {
        if (this.year < that.year) return -1;
        else if (this.year > that.year) return 1;
        else if (this.month < that.month) return -1;
        else if (this.month > that.month) return 1;
        else if (this.day < that.day) return -1;
        else if (this.day > that.day) return 1;
        else return 0;
    }

    public boolean equals(Object y) {
        if (this == y) return true;
        if (y == null) return false;
        if (this.getClass() != y.getClass()) return false;

        Date that = (Date) y; // cast is guaranteed to succeed

        if (this.year != that.year) return false;
        if (this.month != that.month) return false;
        if (this.day != that.day) return false;

        return true;

    }


}
