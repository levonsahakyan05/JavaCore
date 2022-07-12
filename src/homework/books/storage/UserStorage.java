package homework.books.storage;


import homework.books.model.User;


public class UserStorage {
    private User[] array = new User[10];
    private int size = 0;

    public void add(User user) {

        if (size == array.length) {
            increaseArray();
        }
        array[size] = user;
        size++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaseArray() {
        User[] temp = new User[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;

    }
    public User getUserByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmail().equals(email)) {
                return array[i];
            }

        }
        return null;
    }

}
