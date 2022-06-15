package lesson12;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        String name = "Poxos Poxosyan";
        char[] chars = name.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'o') {
                result += "O";

            } else {
                result += chars[i];
            }

        }
        System.out.println(result);

        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));


        }




    }







}
