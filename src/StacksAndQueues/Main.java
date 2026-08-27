package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        stack.push(34);
        stack.push(14);

        stack.push(33);
        stack.push(54);
        stack.pop();
//        System.out.println(stack.peek());
        Queue<Integer> queue = new LinkedList<>(); // uses linkede lists

        queue.add(3);
        queue.add(6);

        queue.add(67);
        queue.remove();
        System.out.println(queue.peek());


    }
}
