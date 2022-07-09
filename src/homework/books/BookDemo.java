package homework.books;

import homework.books.command.BookCommands;
import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.model.Gender;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import students.exception.LessonNotFoundException;

import java.util.Scanner;

public class BookDemo implements BookCommands {
    private static Scanner scanner = new Scanner(System.in);

    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    static String login = "admin";
    static String password = "1234";

    public static void main(String[] args) {
        Author Hovhannes = new Author("Hovhannes", "Tumanyan", "kuty8o@mail.ru", "Male");
        Author Vahan = new Author("Vahan", "Teryan", "kuty865@mail.ru", "Male");
        Author William = new Author("William", "Shakespeare", "kuty8o5@mail.ru", "Male");
        authorStorage.add(Hovhannes);
        authorStorage.add(Vahan);
        authorStorage.add(William);
        bookStorage.add(new Book("5gh", Hovhannes, 5800, 5, "dramatic"));
        bookStorage.add(new Book("5gh", Vahan, 5950, 8, "dramatic"));
        bookStorage.add(new Book("5gh", William, 5800.50, 4, "dramatic"));
        addLoginAndPassword();
        boolean run = true;
        while (run) {
            BookCommands.printCommands();
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

    private static void addLoginAndPassword() {
        System.out.println("Please input login");
        String login1 = scanner.nextLine();
        System.out.println("Please input password");
        String password1 = scanner.nextLine();
        if (!login1.equals(login) || !password1.equals(password)) {
            System.out.println("please input correct login or password");
            addLoginAndPassword();
        }
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
                Book book = new Book(title, authorName, price, count, genre);
                bookStorage.add(book);
                System.out.println("book created");
            } catch (NumberFormatException e) {
                System.out.println("Please input correct price or count");
                addBook();
            }


        }


    }

}