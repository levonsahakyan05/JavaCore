package chapters.chapter12;

public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println(Apple.Winesap.getPrice());
        Apple[] values = Apple.values();
        for (Apple value : values) {
            System.out.println(value + "costs" + value.getPrice());
        }
    }


}
