import java.util.*;

public class GradeSorting {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        //add
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i<num; i++) {
            Student student = new Student(sc.next(), sc.nextInt());
            studentList.add(student);
        }
        //sort
        Collections.sort(studentList);
        //print
        for (Student student : studentList) {
            System.out.print(student.name + ' ');
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    Integer grade;
    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade > o.grade) return 1;
        return -1;
    }
}