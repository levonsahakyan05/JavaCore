package homework;

public class FigurePainter2 {

    public static void main(String[] args) {

        //       for (int i = 0; i < 4; i++) {
        //           for (int j = 0; j <= i; j++) {
        //               System.out.print("  ");
        //           }
        //          for (int k = 4; k > i; k--) {
        //              System.out.print(" *");
        //          }
        //         System.out.println();
        // }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > i; j--) {

                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*   ");


            }

            System.out.println();
        }
        for (int k = 0; k < 4; k++) {
            for (int x = 0; x <= k; x++) {
                System.out.print("  ");
            }
            for (int y = 3; y > k; y--) {
                System.out.print("*   ");
            }
            System.out.println();

        }


    }


}
