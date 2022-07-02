package homework.books.storage;


import homework.books.model.Book;


public class BookStorage {
    private Book[] array = new Book[10];
    private int size = 0;

    public void add(Book book) {

        if (size == array.length) {
            increaseArray();
        }
        array[size] = book;
        size++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaseArray() {
        Book[] temp = new Book[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;

    }


    public void printBooksByAuthorName(String authorName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthorName().equals(authorName)) {
                System.out.println(array[i]);

            }
        }
    }


    public void printBooksByGenre(String genre) {
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i]);

            }
        }

    }

    public void printBooksByPriceRange(int firstNumber, int lastNumber) {
        for (int i = 0; i < size; i++) {
            if (array[i].getPrice() > firstNumber && array[i].getPrice() < lastNumber) {

                System.out.println(array[i]);
            }
        }
    }
}
