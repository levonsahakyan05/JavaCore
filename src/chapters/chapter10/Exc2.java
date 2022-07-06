package chapters.chapter10;

public class Exc2 {
    public static void main(String[] args) {
        int a, d;
        try {
            d = 0;
            a = 42 / d;
            System.out.println("hello world");
        } catch (ArithmeticException e) {
            System.out.println("Hello");
        }
        System.out.println("java");
    }
}
