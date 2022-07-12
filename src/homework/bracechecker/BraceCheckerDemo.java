package homework.bracechecker;

public class BraceCheckerDemo {
    public static void main(String[] args) {
        String text = "Hello from (java}";
       BraceChecker bracechecker = new BraceChecker(text);
        bracechecker.check();

    }








}
