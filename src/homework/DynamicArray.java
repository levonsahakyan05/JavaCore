package homework;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if (size == array.length) {
            increaseArray();
        }
        array[size] = value;
        size++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }

    private void increaseArray() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;

    }

    boolean isEmpty() {

        return size == 0;
    }

    int getByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return 0;
        } else {
            return array[index];
        }

    }

    int getFirstIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    void set(int index, int value) {
        if (index >= 0 && index < size) {
            array[index] = value;
        }
    }

    void add(int index, int value) {
        if (size == array.length) {
            increaseArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];

        }

        array[index] = value;
        size++;
    }

    void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }

            size--;
        }


    }


}
