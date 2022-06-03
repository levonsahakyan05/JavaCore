package homework;

public class PractiseHomework {

    long convert(int minutes) {
        int seconds = minutes * 60;
        return seconds;
    }

    int calcAge(int years) {
        int days = years * 365;
        return days;
    }

    int nextNumber(int number) {
        int x = number + 1;
        return x;
    }

    boolean isSameNum(int a, int b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    boolean lessThanOrEqualToZero(int number) {
        if (number <= 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean reverseBool(boolean value) {
        boolean b = true;
        if (b == value) {

            return false;
        } else {
            return true;
        }
    }

    int maxLength(int[] array1, int[] array2) {
        int x = array1.length;
        int y = array2.length;
        if (x > y && x != y) {
            return x;
        } else {
            return y;
        }
    }


}
