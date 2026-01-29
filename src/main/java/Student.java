public class Student {
    int id;
    String name;
    String department;
    int marks;
    int age;

    public Student(int id, String name, String department, int marks, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
        this.age = age;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getMarks() {
        return marks;
    }

    public int getAge() {
        return age;
    }
}
