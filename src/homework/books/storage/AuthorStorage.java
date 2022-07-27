package homework.books.storage;

import homework.books.exception.AuthorNotFoundException;
import homework.books.model.Author;

public class AuthorStorage {
    private Author[] array = new Author[10];
    private int size = 0;

    public void add(Author author) {

        if (size == array.length) {
            increaseArray();
        }
        array[size] = author;
        size++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaseArray() {
        Author[] temp = new Author[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;

    }

    public int getSize() {
        return size;
    }


    public Author getAuthorByIndex(int index) throws AuthorNotFoundException {
        if (index < 0 || index >= size) {
            throw new AuthorNotFoundException("Author with" + index + "does not exits");
        }
        return array[index];
    }

}
