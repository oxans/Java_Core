package HW9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentStream {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Sveta", Arrays.asList(
                new Course("IT"),
                new Course("Diologist"),
                new Course("Mathematices"),
                new Course("Ches"),
                new Course("photogrape")
        )));

        studentList.add(new Student(2, "Asay", Arrays.asList(
                new Course("ochoonagraphe"),
                new Course("see_food"),
                new Course("pcihologist")

        )));

        studentList.add(new Student(3, "Xan", Arrays.asList(
                new Course("IT"),
                new Course("administration"),
                new Course("managment")
        )));

        System.out.println(studentList.stream()
                 .map(s -> s.getCourseList())
                 .flatMap(c -> c.stream())
                 .map(c -> c.getCourse_Name())
                 .distinct()
                 .collect(Collectors.toList()));


    }
}
