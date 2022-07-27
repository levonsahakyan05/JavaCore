package lesson24;


public class StorageDemo {

    public static void main(String[] args) {
        Storage<Integer> intStorage = new Storage<>();
        intStorage.add(8);
        intStorage.add(4);
        intStorage.print();


        Storage<String> strStorage = new Storage<>();
        strStorage.add("Levon");
        strStorage.print();


    }
}
