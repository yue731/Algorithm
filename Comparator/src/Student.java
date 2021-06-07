import java.util.Comparator;

public class Student {

    private final String name;
    private final int section;

    public Student(String name, int section) {
        this.name = name;
        this.section = section;
    }

    private static class ByName implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class BySection implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o1.section - o2.section;
        }
    }
}
