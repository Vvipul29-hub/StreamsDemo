import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsExamples {

    public static void getNames(List<Student> students) {
        students.stream()
                .map(s -> s.getName())
                .forEach(s -> System.out.println(s));
    }

    public static void getStudentsScoredMoreThan(List<Student> students, int limit) {
        students.stream()
                .filter(s -> s.getMarks()>limit)
                .forEach(s -> System.out.println(s.getName()));
    }

    public static Long getStudentCount(List<Student> students) {
        return students.stream().count();
    }

    public static void namesToUpperCase(List<Student> students) {
        students.stream()
                .forEach(s -> System.out.println(s.getName().toUpperCase()));
    }

    public static void getStudentsBasedOnDept(List<Student> students, String dept) {
        students.stream()
                .filter(s -> s.getDepartment().equals(dept))
                .forEach(s -> System.out.println(s.getName()));
    }

    public static Optional<Student> getStudentWithHighestMarks(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingInt(Student::getMarks));
    }

    public static void getAverageMarks(List<Student> student) {
        student.stream()
                .
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(101, "Alice", "CSE", 85, 20),
                new Student(102, "Bob", "ECE", 72, 21),
                new Student(103, "Charlie", "CSE", 90, 22),
                new Student(104, "David", "ME", 65, 23),
                new Student(105, "Eva", "ECE", 88, 20),
                new Student(106, "Frank", "CSE", 55, 24),
                new Student(107, "Grace", "ME", 78, 22)
        );
        int limit = 80;
        String dept = "CSE";
        System.out.println("Student Names:");
        getNames(students);
        System.out.println("\nStudents who scored more than "+limit+":");
        getStudentsScoredMoreThan(students, limit);
        System.out.println("\nTotal count of students: "+getStudentCount(students));
        System.out.println("\nStudents names in uppercase: ");
        namesToUpperCase(students);
        System.out.println("\nStudents in "+dept+" department:");
        getStudentsBasedOnDept(students, dept);
        System.out.println("\nStudent with the highest mark: ");
        getStudentWithHighestMarks(students)
                .ifPresent(s->System.out.println(s.getName()+" - "+s.getMarks()));
    }
}
