package homework.collection;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        List<FootballTeamMember> testList = new ArrayList<>();
        testList.add(new FootballTeamMember(11, "poxos"));
        testList.add(new FootballTeamMember(13, "petros"));
        testList.add(new FootballTeamMember(7, "Ronaldo"));
        // System.out.println(createFootballTeam(testList));
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(12, "poxos");
        testMap.put(14, "poxos");
        testMap.put(16, "petros");
        // System.out.println(removeFromMap(testMap, 14));
        // printAllMemberNames(testMap);
        // printAllMembers(testMap);


    }

    //Ունենք FootballTeamMember-ի լիստ, պետք է ստանանք HashMap որտեղ կեյ-ը կլինի խաղացողի համարը, իսկ վելյուն իրա անունը։
    static Map<Integer, String> createFootballTeam(List<FootballTeamMember> members) {
        Map<Integer, String> map = new HashMap<>();
        for (FootballTeamMember member : members) {
            map.put(member.getNumber(), member.getName());

        }

        return map;
    }

    //Մեթոդի մեջ պետք է տրված մապ-ից ջնջենք removedNumber համարը եթե կա, ու վերադարձնենք true, եթե չկա վերադարձնենք false
    static boolean removeFromMap(Map<Integer, String> memberMap, Integer removedNumber) {
        for (Integer integer : memberMap.keySet()) {
            if (integer == removedNumber) {
                memberMap.remove(removedNumber);
                return true;
            }
        }

        return false;


    }

    //Մեթոդով տպելու ենք միայն անունները
    static void printAllMemberNames(Map<Integer, String> memberMap) {
        for (Integer integer : memberMap.keySet()) {
            System.out.println(memberMap.get(integer));
        }

    }

    //Մեթոդով տպելու ենք թե համարը, թե խաղացողի անունը հետյալ ձև՝
    // 11 - Poxos Poxosyan
    // 12 - Petros Petrosyan
    static void printAllMembers(Map<Integer, String> memberMap) {
        for (Integer integer : memberMap.keySet()) {
            System.out.println(integer + " - " + memberMap.get(integer));
        }
    }


    static class FootballTeamMember {
        private int number;
        private String name;

        public FootballTeamMember(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
