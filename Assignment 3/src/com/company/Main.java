package com.company;

public class Main {

    public static void main(String[] args) {
        //creating two test scenarios
        LinkedOrderedList<Integer> test1 = new LinkedOrderedList<Integer>();
        LinkedUnorderedList<Integer> test2 = new LinkedUnorderedList<Integer>();
        //Creating Test Integers for use in testing
        Integer str1 = 1;
        System.out.println("str1=" + str1);
        Integer str2 = 22;
        System.out.println("str2=" + str2);
        Integer str3 = 333;
        System.out.println("str3=" + str3);
        Integer str4 = 444444;
        System.out.println("str4=" + str4);
        //LinkedOrderedList specific test scenarios
        System.out.println("test1 isEmpty=" + test1.isEmpty());
        System.out.println("Testing LinkedOrderedList");
        test1.add(str1);
        System.out.println("Added one");
        test1.add(str2);
        System.out.println("Added two");
        test1.add(str3);
        System.out.println("Added three");
        System.out.println("Output toString");
        System.out.println(test1.toString());
        System.out.println("Adding one again");
        test1.add(str1);
        System.out.println(test1.toString());
        //general LinkedList Test for test case one
        System.out.println("first=" + test1.first());
        System.out.println("last=" + test1.last());
        System.out.println("remove first=" + test1.removeFirst());
        System.out.println(test1.toString());
        System.out.println("remove last=" + test1.removeLast());
        System.out.println(test1.toString());
        System.out.println("contains str2: " + test1.contains(str2));
        System.out.println("isEmpty=" + test1.isEmpty());
        System.out.println("size()=" + test1.size());
        //LinkedUnorderedList specific test cases
        System.out.println("Testing LinkedUnOrderedList");
        System.out.println("isEmpty=" + test2.isEmpty());
        System.out.println("Adding str1 to front");
        test2.addToFront(str1);
        System.out.println("Adding str3 to Rear");
        test2.addToRear(str3);
        System.out.println("Adding str1 to front again");
        test2.addToFront(str1);
        System.out.println("Adding str4 after str1");
        test2.addAfter(str4,str1);
        System.out.println("toString: " + test2.toString());
        //general LinkedList Test for test case two
        System.out.println("first" + test2.first());
        System.out.println("last" + test2.last());
        System.out.println("remove first" + test2.removeFirst());
        System.out.println(test2.toString());
        System.out.println("remove last" + test2.removeLast());
        System.out.println(test2.toString());
        System.out.println("contains str2: " + test2.contains(str2));
        System.out.println("isEmpty=" + test2.isEmpty());
        System.out.println("size()=" + test2.size());
    }

}
