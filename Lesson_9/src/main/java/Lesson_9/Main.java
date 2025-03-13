package Lesson_9;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student student0 = new Student("Семен", "101", 1, new int[]{3, 2, 3, 2, 4});
        Student student1 = new Student("Дмитрий", "201", 2, new int[]{5, 4, 5, 4, 5});
        Student student2 = new Student("Константин", "202", 2, new int[]{3, 4, 3, 4, 5});
        Student student3 = new Student("Татьяна", "103", 1, new int[]{3, 3, 3, 3, 2});
        Student student4 = new Student("Сергей", "301", 3, new int[]{2, 5, 5, 2, 5});
        Student student5 = new Student("Ринат", "302", 3, new int[]{4, 3, 4, 4, 5});
        ArrayList<Student> studentsList = new ArrayList<Student>(Arrays.asList(student0, student1, student2, student3, student4, student5));

        Student.printStudents(studentsList, 2);
        System.out.println();
        Student.print(studentsList);
        Student.deleteStudents(studentsList);
        System.out.println("\nПереведены на следующий курс");
        Student.print(studentsList);

        System.out.println("\n-----------------\n");
        PhoneBook contact = new PhoneBook();
        contact.add("Сидров", "913456789");
        contact.add("Иванов", "997654321");
        contact.add("Сидров", "915666777");
        contact.add("Сидров", "915666777");

        System.out.println("Номера Сидров: " + contact.get("Сидров"));
        System.out.println("Номера Иванов: " + contact.get("Иванов"));
        System.out.println("Номера Петров: " + contact.get("Петров"));
    }
}