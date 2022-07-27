package homework.collection;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("hjfvi");
        testList.add("iyuf");
        testList.add("iyuf");
        testList.add("Levon");
        testList.add("Levon");
        //System.out.println(arrayToList(new String[]{"Hello from java"}));
        // System.out.println(removeById(testList, 0));
        //System.out.println(listToSet(testList));
        // printFirstFive(testList);
        // System.out.println(sizeOfList(testList));
        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(6);
        intList.add(9);
        intList.add(14);
        //System.out.println(listToLinkedList(intList));
        // System.out.println(reverseNumbers(intList));
    }

    //մեթոդը գրել այնպես, որ կանչենք, ու իրան ստրինգների մասիվ տանք, ինքը վերադարձնի նույն էլեմենտներով ArrayList
    static List<String> arrayToList(String[] values) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, values);
        return list;
    }

    //մեթոդը գրել այնպես, որ կանչենք ու տանք ինչ որ լիստ, ու ինդեքս, ինքը ջնջե էդ ինդեքսի տակ գտնվող էլեմենտը, ու վերադարձնե նույն լիստը, առանց էդ էլեմենտի։
    static List<String> removeById(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            return list;
        }
        return null;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած String-ների լիստ, վերադարձնի նույն արժեքներով HashSet
    static Set<String> listToSet(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած Integer-ների լիստ, վերադարձնի նույն արժեքներով LinkedList-ի օբյեկտ։
    static LinkedList<Integer> listToLinkedList(List<Integer> list) {
        List<Integer> linkedList = new LinkedList<>(list);
        return (LinkedList<Integer>) linkedList;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած Integer-ների լիստ, վերադարձնի նոր լիստ, որի մեջ էլեմենտները կլինեն հակառակ հերթականությամբ։
    static List<Integer> reverseNumbers(List<Integer> list) {
        Collections.reverse(list);
        return list;
    }

    // մեթոդը գրել այնպես, որ ինչ մեծությամբ լիստ էլ տանք էս մեթոդին, ինքը տպե մենակ սկզբի 5 հատը։
    static void printFirstFive(List<String> list) {
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
            if (i == 4) {
                break;
            }

        }

    }

    // մեթոդը գրել այնպես, որ ինչ list տանք վերադարձնի թե քանի էլեմենտ կա էդ լիստ-ի մեջ
    static int sizeOfList(List<String> list) {
        return list.size();
    }

}


