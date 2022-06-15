package chapters.chapter7;

public class Overload {
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        double result;
        ob.test();
        ob.test(5);
        ob.test(6, 8);
        result = ob.test(12.3);
        System.out.println(+result);

    }


}
