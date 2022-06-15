package chapters.chapter7;

public class OverloadDemo {

    void test() {
        System.out.println("parametrer chkan");
    }

    void test(int a) {
        System.out.println(" a: " + a);
    }

    void test(int a, int b) {
        System.out.println(" a:" + a + " b:" + b);
    }

    double test(double a) {
        System.out.println(" double a:" + a);
        return a * a;
    }


}
