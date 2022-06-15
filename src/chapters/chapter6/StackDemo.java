package chapters.chapter6;

public class StackDemo {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(8);
        myStack.push(6);
        myStack.push(9);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(5);

    }


}
