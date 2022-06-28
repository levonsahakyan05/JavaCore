package homework.books;

import java.util.Scanner;

public class BookDemo implements BookCommands {
    private static Scanner scanner = new Scanner(System.in);

    private static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Please input " + EXIT + " for exit");
            System.out.println("Please input " + ADD_BOOK + " for add book");
            System.out.println("Please input " + PRINT_ALL_BOOKS + " for print all books");
            System.out.println("Please input " + PRINT_BOOKS_BY_AUTHORNAME + " for print books by authorName");
            System.out.println("Please input " + PRINT_BOOKS_BY_GENRE + " for print books by genre");
            System.out.println("Please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");
            int command = Integer.parseInt(scanner.nextLine());
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
            }
        }


    }

    private static void printBooksByPriceRange() {
        System.out.println("please input first number");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input last number");
        int lastNumber = Integer.parseInt(scanner.nextLine());
        if (firstNumber > lastNumber) {
            System.out.println("Wrong number");
        } else {
            bookStorage.printBooksByPriceRange(firstNumber, lastNumber);

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
        System.out.println("Please input book's title");
        String title = scanner.nextLine();
        System.out.println("Please input book's authorName");
        String authorName = scanner.nextLine();
        System.out.println("Please input book's price");
        String priceStr = scanner.nextLine();
        System.out.println("Please input book's count");
        String countStr = scanner.nextLine();
        System.out.println("Please input book's genre");
        String genre = scanner.nextLine();
        double price = Double.parseDouble(priceStr);
        int count = Integer.parseInt(countStr);


        Book book = new Book(title, authorName, price, count, genre);
        bookStorage.add(book);
        System.out.println("book created");
    }

}