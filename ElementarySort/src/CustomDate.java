public class CustomDate implements Comparable<CustomDate> {

    private final int month, day, year;

    public CustomDate(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public int compareTo(CustomDate that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return 1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return 1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return 1;
        return 0;
    }

    public static void main(String[] args) {
        CustomDate cd1 = new CustomDate(7, 31, 1993);
        CustomDate cd2 = new CustomDate(7, 6, 1989);
        
    }
}
