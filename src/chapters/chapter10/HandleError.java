package chapters.chapter10;

import java.util.Random;

public class HandleError {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        Random r = new Random();

        for (int i = 0; i <3100 ; i++) {
            try{
                b = r.nextInt();
                c = r.nextInt();
                a = 5210 / (b / c);
            }catch (ArithmeticException e){
                System.out.println("krlgh");
                a = 0;
            }
            System.out.println(" a:" + a);
        }
    }
}
