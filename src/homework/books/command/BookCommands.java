package homework.books.command;

public interface BookCommands {
    int EXIT = 0;
    int ADD_BOOK = 1;
    int PRINT_ALL_BOOKS = 2;
    int PRINT_BOOKS_BY_AUTHORNAME = 3;
    int PRINT_BOOKS_BY_GENRE = 4;
    int PRINT_BOOKS_BY_PRICE_RANGE = 5;
    int ADD_AUTHOR = 6;
    int PRINT_ALL_AUTHORS =7;
    static void printCommands(){
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_BOOK + " for add book");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for print all books");
        System.out.println("Please input " + PRINT_BOOKS_BY_AUTHORNAME + " for print books by authorName");
        System.out.println("Please input " + PRINT_BOOKS_BY_GENRE + " for print books by genre");
        System.out.println("Please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");
        System.out.println("Please input " +ADD_AUTHOR + " for add author");
        System.out.println("Please input " +PRINT_ALL_AUTHORS + " for print all authors");
    }
}
