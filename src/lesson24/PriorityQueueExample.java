package lesson24;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        queue.add("petros");
        queue.add("martiros");
        queue.add("poxos");

      System.out.println( queue.peek());
      System.out.println( queue.peek());
      System.out.println( queue.peek());
    }
}
