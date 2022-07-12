package students;

import students.command.Commands;
import students.exception.LessonNotFoundException;
import students.model.Lesson;
import students.model.Student;
import students.model.User;
import students.model.UserType;
import students.storage.LessonStorage;
import students.storage.StudentStorage;
import students.storage.UserStorage;

import java.util.Scanner;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    private static LessonStorage lessonstorage = new LessonStorage();
    private static UserStorage userStorage = new UserStorage();
    private static User currentUser = null;

    public static void main(String[] args) {
        initData();

        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
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
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command");
            }

        }

    }

    private static void login() {
        System.out.println("Please input email,password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUserByEmail(emailPassword[0]);
        if (user == null) {
            System.out.println("User with " + emailPassword[0] + " does not exists!");

        } else {
            if (user.getPassword().equals(emailPassword[1])) {
                currentUser = user;
                if (user.getUserType() == UserType.ADMIN) {
                    loginAdmin();
                } else if (user.getUserType() == UserType.USER) {
                    loginUser();
                }
            } else {
                System.out.println("Password is wrong!");
            }
        }
    }

    private static void loginUser() {
        System.out.println("Welcome " + currentUser.getName());
        boolean run = true;
        while (run) {
            Commands.printUserCommands();
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
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLessonName();
                    break;
                case PRINT_STUDENTS_COUNT:
                    System.out.println("students count" + studentStorage.getSize());
                    break;
                case PRINT_ALL_LESSONS:
                    lessonstorage.print();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }
    }

    private static void register() {
        System.out.println("Please input name,surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("Please input correct data");
        } else {
            if (userStorage.getUserByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setUserType(UserType.USER);
                userStorage.add(user);
                System.out.println("User created!");
            } else {
                System.out.println("User with" + userData[2] + "already exists!");
            }

        }


    }

    private static void loginAdmin() {
        System.out.println("Welcome " + currentUser.getName());
        boolean run = true;
        while (run) {
            Commands.printAdminCommands();
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

    private static void initData() {
        User admin = new User("admin", "admin", "admin@mail.ru", "admin", UserType.ADMIN);
        userStorage.add(admin);
        Lesson java = new Lesson("java", "teacher", 7, 1234);
        Lesson mysql = new Lesson("mysql", "teacher mysql", 7, 1234);
        Lesson php = new Lesson("php", "teacher php", 7, 12345);
        lessonstorage.add(java);
        lessonstorage.add(mysql);
        lessonstorage.add(php);
        studentStorage.add(new Student("poxos", "poxosyan", 24, "123568", "gyumri", java, admin));
        studentStorage.add(new Student("poxos", "petrosyan", 24, "12356866", "gyumri", mysql, admin));
        studentStorage.add(new Student("martiros", "poxosyan", 25, "1235689", "gyumri", php, admin));

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
                Student student = new Student(name, surname, age, phoneNumber, city, lesson, currentUser);
                studentStorage.add(student);
                System.out.println("Student created");
            } catch (LessonNotFoundException | NumberFormatException e) {
                System.out.println("Please choose correct index or number");
                addStudent();


            }

        }


    }
}

