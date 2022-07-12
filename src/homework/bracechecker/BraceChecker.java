package homework.bracechecker;

import chapters.chapter6.Stack;

public class BraceChecker {

    String text;
    private Stack stack = new Stack();

    BraceChecker(String text) {
        this.text = text;

    }

    void check() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int last;
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    last = stack.pop();
                    if (last == 0) {
                        System.err.print("Eror: closed" + c + " " + "but  not opened" + i);
                    } else if (last != '(') {
                        System.err.println("Eror: closed" + c + " " + "but opened" + (char) last + "at" + i);
                    }
                    break;
                case ']':
                    last = stack.pop();
                    if (last == 0) {
                        System.err.print("Eror: closed" + c + " " + "but  not opened" + i);
                    } else if (last != '[') {
                        System.err.println("Eror: closed" + c + " " + "but opened" + (char) last + "at" + i);

                    }
                    break;
                case '}':
                    last = stack.pop();
                    if (last == 0) {
                        System.err.print("Eror: closed" + c + " " + "but  not opened" + i);
                    } else if (last != '{') {
                        System.err.println("Eror: closed" + c + " " + "but opened" + (char) last + "at" + i);

                        break;
                    }
            }
        }

    }
}



