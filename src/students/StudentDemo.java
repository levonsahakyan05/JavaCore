package students;

import students.command.Commands;
import students.exception.LessonNotFoundException;
import students.model.Lesson;
import students.model.Student;
import students.storage.LessonStorage;
import students.storage.StudentStorage;

import java.util.Scanner;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    private static LessonStorage lessonstorage = new LessonStorage();

    public static void main(String[] args) {
        Lesson java = new Lesson("java", "teacher", 7, 1234);
        Lesson mysql = new Lesson("mysql", "teacher mysql", 7, 1234);
        Lesson php = new Lesson("php", "teacher php", 7, 12345);
        lessonstorage.add(java);
        lessonstorage.add(mysql);
        lessonstorage.add(php);
        studentStorage.add(new Student("poxos", "poxosyan", 24, "123568", "gyumri", java));
        studentStorage.add(new Student("poxos", "petrosyan", 24, "12356866", "gyumri", mysql));
        studentStorage.add(new Student("martiros", "poxosyan", 25, "1235689", "gyumri", php));
        boolean run = true;
        while (run) {
            Commands.printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }


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
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_ALL_LESSONS:
                    lessonstorage.print();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }

    }

    private static void addLesson() {
        System.out.println("please input lesson name");
        String lessonName = scanner.nextLine();
        System.out.println("please input lesson teacherName");
        String teacherName = scanner.nextLine();
        try {
            System.out.println("please input lesson duration by month");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println("please input lesson price");
            double price = Double.parseDouble(scanner.nextLine());
            Lesson lesson = new Lesson(lessonName, teacherName, duration, price);
            lessonstorage.add(lesson);
            System.out.println("lesson created!");
        } catch (NumberFormatException e) {
            System.out.println("Please input correct price or duration");
            addLesson();
        }


    }


    private static void changeStudentsLessonName() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student == null) {
            System.out.println("Wrong index !!!");
            changeStudentsLessonName();
        } else {
            if (lessonstorage.getSize() != 0) {
                lessonstorage.print();
                System.out.println("please choose lesson index");
                try {
                    int lessonIndex = Integer.parseInt(scanner.nextLine());
                    Lesson lesson = lessonstorage.getLessonByIndex(lessonIndex);
                    student.setLesson(lesson);
                    System.out.println("lesson changed!");
                } catch (LessonNotFoundException | NumberFormatException e) {
                    System.out.println("Please input correct number or index");
                    changeStudentsLessonName();
                }

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
        try {
            int index = Integer.parseInt(scanner.nextLine());
            studentStorage.deleteByIndex(index);
        } catch (NumberFormatException e) {
            System.out.println("Please input correct index");
        }
    }

    private static void addStudent() {
        if (lessonstorage.getSize() != 0) {
            lessonstorage.print();
            System.out.println("please choose lesson index");

            Lesson lesson = null;
            try {
                int lessonIndex = Integer.parseInt(scanner.nextLine());
                lesson = lessonstorage.getLessonByIndex(lessonIndex);
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
                int age = Integer.parseInt(ageStr);
                Student student = new Student(name, surname, age, phoneNumber, city, lesson);
                studentStorage.add(student);
                System.out.println("Student created");
            } catch (LessonNotFoundException | NumberFormatException e) {
                System.out.println("Please choose correct index or number");
                addStudent();


            }

        }


    }
}

