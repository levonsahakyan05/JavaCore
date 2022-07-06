package homework.books;

import homework.books.command.BookCommands;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import students.exception.LessonNotFoundException;

import java.util.Scanner;

public class BookDemo implements BookCommands {
    private static Scanner scanner = new Scanner(System.in);

    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    public static void main(String[] args) {
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
        String gender1 = "Male";
        String gender2 = "Female";
        return gender.equals(gender1) || gender.equals(gender2);
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
                System.out.println("Please input book's title");
                String title = scanner.nextLine();
                System.out.println("Please input book's genre");
                String priceStr = scanner.nextLine();
                System.out.println("Please input book's count");
                String countStr = scanner.nextLine();
                String genre = scanner.nextLine();
                System.out.println("Please input book's price");
                double price = Double.parseDouble(priceStr);
                int count = Integer.parseInt(countStr);
                Book book = new Book(title, authorName, price, count, genre);
                bookStorage.add(book);
                System.out.println("book created");
            } catch (LessonNotFoundException | NumberFormatException e) {
                System.out.println("please input correct index or number");
                addBook();
            }


        }


    }

}