package homework.books;

import homework.books.command.BookCommands;
import homework.books.exception.AuthorNotFoundException;
import homework.books.model.*;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import homework.books.storage.UserStorage;


import java.util.Scanner;

public class BookDemo implements BookCommands {
    private static Scanner scanner = new Scanner(System.in);

    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static UserStorage userStorage = new UserStorage();
    private static User currentUser = null;

    public static void main(String[] args) {
        initData();
        boolean run = true;
        while (run) {
            BookCommands.printLoginCommands();
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
                System.out.println("Password is wrong");
            }
        }
    }

    private static void loginUser() {
        System.out.println("Welcome " + currentUser.getName());
        boolean run = true;
        while (run) {
            BookCommands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case LOGOUT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_BOOKS_BY_AUTHORNAME:
                    printBooksByAuthorName();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenre();
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;
                case PRINT_ALL_AUTHORS:
                    authorStorage.print();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }
    }

    private static void loginAdmin() {
        System.out.println("Welcome " + currentUser.getName());
        boolean run = true;
        while (run) {
            BookCommands.printAdminCommands();
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
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_BOOKS_BY_AUTHORNAME:
                    printBooksByAuthorName();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenre();
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_ALL_AUTHORS:
                    authorStorage.print();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }
    }

    private static void initData() {
        User admin = new User("admin", "admin", "admin@mail.ru", "admin", UserType.ADMIN);
        userStorage.add(admin);
        Author Hovhannes = new Author("Hovhannes", "Tumanyan", "kuty8o@mail.ru", "Male");
        Author Vahan = new Author("Vahan", "Teryan", "kuty865@mail.ru", "Male");
        Author William = new Author("William", "Shakespeare", "kuty8o5@mail.ru", "Male");
        authorStorage.add(Hovhannes);
        authorStorage.add(Vahan);
        authorStorage.add(William);
        bookStorage.add(new Book("5gh", Hovhannes, 5800, 5, "dramatic",admin));
        bookStorage.add(new Book("5gh", Vahan, 5950, 8, "dramatic",admin));
        bookStorage.add(new Book("5gh", William, 5800.50, 4, "dramatic",admin));
    }


    private static void addAuthor() {
        System.out.println("Please input Author name");
        String name = scanner.nextLine();
        System.out.println("Please input Author surname");
        String surname = scanner.nextLine();
        String email;
        do {
            System.out.println("Please input Author email");
            email = scanner.nextLine();
        }
        while (!isValidEmail(email));

        String gender;
        do {
            System.out.println("Please input Author gender");
            gender = scanner.nextLine();
        }
        while (!isValidGender(gender));
        Author author = new Author(name, surname, email, gender);
        authorStorage.add(author);
        System.out.println("author created");
    }

    private static boolean isValidGender(String gender) {
        Gender gender1 = Gender.MALE;
        String gender1Str = gender1.name();
        Gender gender2 = Gender.FEMALE;
        String gender2Str = gender2.name();
        return gender.equals(gender1Str) || gender.equals(gender2Str);
    }

    private static boolean isValidEmail(String email) {
        return email.length() >= 12 && (email.contains("@gmail.com") || email.contains("@mail.ru"));
    }


    private static void printBooksByPriceRange() {
        try {
            System.out.println("please input first number");
            int firstNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input last number");
            int lastNumber = Integer.parseInt(scanner.nextLine());
            if (firstNumber > lastNumber) {
                System.out.println("Wrong number");
            } else {
                bookStorage.printBooksByPriceRange(firstNumber, lastNumber);

            }
        } catch (NumberFormatException e) {
            System.out.println("Please input correct first number or last number");
        }


    }

    private static void printBooksByGenre() {
        System.out.println("please input Genre");
        String genre = scanner.nextLine();
        bookStorage.printBooksByGenre(genre);
    }

    private static void printBooksByAuthorName() {
        System.out.println("Please input AuthorName");
        String authorName = scanner.nextLine();
        bookStorage.printBooksByAuthorName(authorName);
    }


    private static void addBook() {
        if (authorStorage.getSize() != 0) {
            authorStorage.print();
            System.out.println("Please choose author index");
            Author authorName = null;
            try {
                int authorIndex = Integer.parseInt(scanner.nextLine());
                authorName = authorStorage.getAuthorByIndex(authorIndex);
            } catch (AuthorNotFoundException | NumberFormatException e) {
                System.out.println("please input correct index or number");
                addBook();
            }
            System.out.println("Please input book's title");
            String title = scanner.nextLine();
            System.out.println("Please input book's price");
            String priceStr = scanner.nextLine();
            System.out.println("Please input book's count");
            String countStr = scanner.nextLine();
            System.out.println("Please input book's genre");
            String genre = scanner.nextLine();
            try {
                double price = Double.parseDouble(priceStr);
                int count = Integer.parseInt(countStr);
                Book book = new Book(title, authorName, price, count, genre,currentUser);
                bookStorage.add(book);
                System.out.println("book created");
            } catch (NumberFormatException e) {
                System.out.println("Please input correct price or count");
                addBook();
            }


        }


    }
}


