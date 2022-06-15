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
    }

    private void increaseArray() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];

        }
        array = temp;

    }

    boolean isEmpty() {
        if (size == 0) {

            return true;
        }
        return false;
    }

    int getByIndex(int index) {
        for (int i = 0; i < array.length ; i++) {
            if (index == i) {
                return array[i];
            }

        }
        return 0;
    }

    int getFirstIndexByValue(int value) {
        for (int i = 0; i < array.length ; i++) {
          if (value == array[i]) {

        return i;
          }
        }


      return 0;
    }

    void set(int index, int value) {
        for (int i = 0; i < array.length ; i++) {
            if (index == i ){
           array[index] = value;
                System.out.println(array[i]);

            }
        }

    }

    void add(int index, int value) {

    }

    void delete(int index) {
        for (int i = 0; i <array.length ; i++) {
          if (index == i) {
              array[i] =array[i] - array[index];
              System.out.println(array[i]);
          }
        }

    }


}
