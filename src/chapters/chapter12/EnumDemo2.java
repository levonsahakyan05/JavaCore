package chapters.chapter12;

public class EnumDemo2 {
    public static void main(String[] args) {
        Apple apple;

        Apple[] values = Apple.values();
        for (Apple value : values) {
            System.out.println(value);
        }
        apple = Apple.valueOf("Winesap");
        System.out.println(apple);

    }

}
