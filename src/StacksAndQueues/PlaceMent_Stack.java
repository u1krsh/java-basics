package StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class PlaceMent_Stack {
    static int n = 5;
    static int[] stack = new int[n];
    static int top = -1;
    static void push(int num){
        if(top >= n-1){
            System.out.println("Stack OverFlow");
        }
        else {
            stack[++top] = num;
        }
    }

    static int pop(){
        if(top == -1){
            System.out.println("Stack UnderFlow");
            return  Integer.MIN_VALUE;
        }
        else {
            int x = stack[top--];
            return x;
        }
    }

    static int peek(){
        if(top == -1){
            System.out.println("Stack Empty");
        }
        return stack[top];
    }

    static int isFull(){
        if(top >= n-1){
            return 1;
        }
        else {
            return 0;
        }
    }
    static int isEmpty(){
        if(top == -1){
            return 1;
        }
        else {
            return 0;
        }
    }

    static int size(){

        return top+1;
    }




    public static void main(String[] args) {

        boolean isOnline = true;
        while(isOnline==true){
            System.out.println("***STACK***");
            System.out.println("SELECT CHOICE 1-push, 2-pop,3-peek, 4-isFull, 5-isEmpty, 6-size, 7- Exit");
            Scanner sc = new Scanner(System.in);
            int sus = sc.nextInt();

            switch (sus){
                case 1: int x = sc.nextInt(); push(x); break;
                case 2: System.out.println(pop());break;
                case 3: System.out.println(peek());break;
                case 4: System.out.println(isFull());break;
                case 5: System.out.println(isEmpty());break;
                case 6: System.out.println(size());break;
                case 7: isOnline = false;break;
                default: System.out.println("Invalid Input");

            }
        }

    }

}
