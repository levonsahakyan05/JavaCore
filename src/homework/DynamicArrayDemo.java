package homework;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynArray = new DynamicArray();
        dynArray.add(2);
        dynArray.add(5);
        System.out.println(dynArray.isEmpty());
        System.out.println(dynArray.getByIndex(1));
        System.out.println(dynArray.getFirstIndexByValue(2));
        dynArray.set(3,20);
        dynArray.add(1,7);
        dynArray.delete(1);

    }

}
