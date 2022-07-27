package lesson25;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();

        names.put(123,"poxos");
        names.put(222,"petros");


        String s = names.get(123);
        System.out.println(s);
        Set<Integer> integers = names.keySet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
