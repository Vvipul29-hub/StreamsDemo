import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static double getAverageMarks(List<Student> student) {
        return student.stream()
                .mapToInt(Student::getMarks)
                .average()
                .orElse(0.0);
    }

    public static void sortStudentsByMarksDesc(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .forEach(s->System.out.println(s.getName()));
    }

    public static void groupStudentsByDept(List<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment))
                .forEach((dept, studentList) -> {
                    System.out.println("Department: "+dept);
                    studentList.forEach(s -> System.out.println(s.getName()));
                });
    }

    public static void countStudentsInEachDept(List<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .forEach((dept, count) -> {
                    System.out.println("Department: "+dept+", Count: "+count);
                });
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
        int scoredMoreThanLimit = 80;
        String dept = "CSE";
        System.out.println("Student Names:");
        getNames(students);
        System.out.println("\nStudents who scored more than "+scoredMoreThanLimit+":");
        getStudentsScoredMoreThan(students, scoredMoreThanLimit);
        System.out.println("\nTotal count of students: "+getStudentCount(students));
        System.out.println("\nStudents names in uppercase: ");
        namesToUpperCase(students);
        System.out.println("\nStudents in "+dept+" department:");
        getStudentsBasedOnDept(students, dept);
        System.out.println("\nStudent with the highest mark: ");
        getStudentWithHighestMarks(students)
                .ifPresent(s->System.out.println(s.getName()+" - "+s.getMarks()));
        System.out.println("\nAverage marks of all students: "+getAverageMarks(students));
        System.out.println("\nSorted list of students by marks in descending order:");
        sortStudentsByMarksDesc(students);
        System.out.println("\nGrouping students by department:");
        groupStudentsByDept(students);
        System.out.println("\nCount of students in each department:");
        countStudentsInEachDept(students);
    }
}
