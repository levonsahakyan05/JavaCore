package homework;

public class Figure2 {
    public static void main(String[] args) {


        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                    System.out.print("  ");



            }
          for ( int k = 4;k>=i; k--) {
                  System.out.print("* ");



          }
            System.out.println();
        }

    }
}