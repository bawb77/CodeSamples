package com.company;


public class Main {

    public static void main(String[] args) {

        LinkedStack<String> L1 = new LinkedStack<String>();

        LinkedDropOutStack<String> L2 = new LinkedDropOutStack<String>();

        String LN1 = new String("asdf");
        String LN2 = new String("fdas");
        String LN3 = new String("1234");
        String LN4 = new String("4321");
        String LN5 = new String("Yeeee");

        System.out.println("Linked Stack is size: " + L1.size());
        System.out.println("LinkedStack is Empty: " + L1.isEmpty());
        L1.push(LN1);
        L1.push(LN2);
        L1.push(LN3);
        L1.push(LN4);
        L1.push(LN5);
        System.out.println("Linked Stack Has: " + L1.toString());
        System.out.println("Linked Stack is size: " + L1.size());
        System.out.println("LinkedStack is Empty: " + L1.isEmpty());

        System.out.println("Linked drop out Stack is size: " + L2.size());
        System.out.println("Linked drop out Stack is Empty: " + L2.isEmpty());
        L2.push(LN1);
        L2.push(LN2);
        L2.push(LN3);
        L2.push(LN4);
        L2.push(LN5);
        System.out.println("Linked drop out Stack Has: " + L2.toString());
        System.out.println("Linked drop out Stack is size: " + L2.size());
        System.out.println("Linked drop out Stack is Empty: " + L2.isEmpty());

        System.out.println("L1 Peek:" + L1.peek());
        System.out.println("L2 Peek:" + L2.peek());

        System.out.println("Pushing over limit on L2");
        L2.push(LN1);
        System.out.println("Linked drop out Stack is size: " + L2.size());
        System.out.println("Linked drop out Stack Has: " + L2.toString());
    }
}
