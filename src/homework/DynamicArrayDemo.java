package homework;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynArray = new DynamicArray();
        dynArray.add(2);
        dynArray.add(5);
        dynArray.print();
        System.out.println(dynArray.isEmpty());
        System.out.println(dynArray.getByIndex(0));
        System.out.println(dynArray.getFirstIndexByValue(5));
        dynArray.set(1, 20);
        dynArray.print();
        dynArray.add(1,35);
        dynArray.print();
        dynArray.delete(0);
        dynArray.print();

    }

}
