package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //LinkedQueue Tester
        LinkedQueue<String> L1 = new LinkedQueue<String>();
        // create test strings
        String LN1 = new String("ABCDE");
        String LN2 = new String("EDCBA");
        String LN3 = new String("ABCBA");
        System.out.println("isEmpty(1): " + L1.isEmpty());
        System.out.println("Enqueue L1: " + LN1 + LN2 + LN3);
        //enqueue test strings
        L1.enqueue(LN1);
        L1.enqueue(LN2);
        // test queue
        System.out.println("isEmpty(2): " + L1.isEmpty());
        System.out.println("Size = " + L1.size());
        System.out.println("toString: " + L1.toString());
        System.out.println("First: " + L1.first());
        System.out.println("Dequeuing L1");
        //dequeue queue to prepare for palindrone test
        L1.dequeue();
        L1.dequeue();
        System.out.println("isEmpty(3): " + L1.isEmpty());
        System.out.println("Size = " + L1.size());
        System.out.println("toString: " + L1.toString());;

        //CircularArrayQueue Tester
        CircularArrayQueue<String> L2 = new CircularArrayQueue<String>();
        System.out.println("2isEmpty(1): " + L2.isEmpty());
        System.out.println("2Enqueue L2: " + LN1 + LN2 + LN3);
        //enqueue circulararrayqueue
        L2.enqueue(LN2);
        L2.enqueue(LN1);
        //test circulararrayqueue
        System.out.println("2isEmpty(2): " + L2.isEmpty());
        System.out.println("2Size = " + L2.size());
        System.out.println("2toString: " + L2.toString());
        System.out.println("2First: " + L2.first());
       // System.out.println("First: " + L2.first());

        //Palindrone Tester
        LinkedStack<String> L3 = new LinkedStack<String>();
        // take input for palindrone test
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //interate through string one charater at a time and enqueue and push them.
        for (char temp : str.toCharArray())
        {
            L1.enqueue(String.valueOf(temp));
            L3.push(String.valueOf(temp));
        }
        //test for palindrone and return result
        System.out.println("Is a palindrone?: " + (L1.toString().equals(L3.toString())));
    }
}
