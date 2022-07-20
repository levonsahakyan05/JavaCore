package chapters.chapter12;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.RedDel;
        System.out.println("ap: " + ap);
        ap = Apple.GoldenDel;

        if (ap == Apple.GoldenDel){
            System.out.println(ap);
        }
        switch (ap){
            case Jonathan:
                System.out.println("Grade Jonathan is red");
                break;
            case GoldenDel:
                System.out.println("Grade GoldenDel is yellow");
                break;
            case RedDel:
                System.out.println("Grade RedDel is red ");
                break;
            case Winesap:
                System.out.println("Grade Winesap is red");
                break;
            case CortLand:
                System.out.println("Grade Cortland is red");
                break;
        }
    }
}
