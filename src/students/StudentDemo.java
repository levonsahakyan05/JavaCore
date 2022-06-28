package students;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        studentStorage.add(new Student("poxos", "poxosyan", 24, "1256987", "Gyumri", "Java"));
        studentStorage.add(new Student("petros", "poxosyan", 24, "125687", "Gyumri", "Pyton"));
        studentStorage.add(new Student("martiros", "poxosyan", 42, "12566987", "Gyumri", "Php"));
        boolean run = true;
        while (run) {
            System.out.println("Please input " + EXIT + " for exit");
            System.out.println("Please input " + ADD_STUDENT + " for add student");
            System.out.println("Please input " + PRINT_ALL_STUDENTS + " for print all students");
            System.out.println("Please input " + DELETE_STUDENT_BY_INDEX + " for delete student by index");
            System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON + " for print student by lesson");
            System.out.println("Please input " + PRINT_STUDENTS_COUNT + " for print students count");
            System.out.println("Please choose " + CHANGE_STUDENT_LESSON + " for change student's lesson");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case DELETE_STUDENT_BY_INDEX:
                    deleteByIndex();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLessonName();
                    break;
                case PRINT_STUDENTS_COUNT:
                    System.out.println("students count" + studentStorage.getSize());
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentsLessonName();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }

    }

    private static void changeStudentsLessonName() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student == null) {
            System.out.println("Wrong index !!!");
        } else {
            System.out.println("Please input new lesson name");
            String newLessonName = scanner.nextLine();
            if (newLessonName != null && !newLessonName.trim().equals("")) {
                student.setLesson(newLessonName.trim());
                System.out.println("lesson name changed!");
            }
        }
    }

    private static void printStudentsByLessonName() {
        System.out.println("Please input lesson name");
        String lessonName = scanner.nextLine();
        studentStorage.printStudentsByLessonName(lessonName);
    }

    private static void deleteByIndex() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        studentStorage.deleteByIndex(index);
    }

    private static void addStudent() {
        System.out.println("Please input student's name");
        String name = scanner.nextLine();
        System.out.println("Please input student's surname");
        String surname = scanner.nextLine();
        System.out.println("Please input student's age");
        String ageStr = scanner.nextLine();
        System.out.println("Please input student's phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input student's city");
        String city = scanner.nextLine();
        System.out.println("Please input student's lesson");
        String lesson = scanner.nextLine();
        int age = Integer.parseInt(ageStr);
        if (lesson != null) {
            lesson = lesson.trim();
        }
       Student student = new Student(name,surname,age,phoneNumber,city,lesson);
        studentStorage.add(student);
        System.out.println("student created");


    }

}
