import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        LinkedStack<String> L1 = new LinkedStack<String>();
        LinkedQueue<String> L2 = new LinkedQueue<String>();
        CircularArrayQueue<String> L3 = new CircularArrayQueue<String>();
        String LN1 = new String("asdf");
        String LN2 = new String("fdas");
        String LN3 = new String("1234");
        String LN4 = new String("4321");
        String LN5 = new String("Yeeee");

        //Linked Stack Tester
        System.out.println("Linked Stack is size: " + L1.size());
        System.out.println("LinkedStack is Empty: " + L1.isEmpty());
        L1.push(LN1);
        L1.push(LN2);
        L1.push(LN3);
        L1.push(LN4);
        L1.push(LN5);
        System.out.println("Linked Stack Has: " + L1.toString());
        System.out.println("Linked Stack is size: " + L1.size());
        System.out.println("Linked Stack Iterator Test: ");
        Iterator<String> iterTest = L1.iterator();
        System.out.println("Linked Stack hasNext():" + iterTest.hasNext());
        System.out.println("Linked Stack next(1): " + iterTest.next());
        System.out.println("Linked Stack next(2): " + iterTest.next());
        System.out.println("Linked Stack forEach Test: ");
        for(String temp : L1)
        {
            System.out.println(temp);
        }


        // Linked Queue Tester
        System.out.println("Linked Queue is size: " + L2.size());
        System.out.println("Linked Queue is Empty: " + L2.isEmpty());
        L2.enqueue(LN1);
        L2.enqueue(LN2);
        L2.enqueue(LN3);
        L2.enqueue(LN4);
        L2.enqueue(LN5);
        System.out.println("Linked Queue Has: " + L2.toString());
        System.out.println("Linked Queue is size: " + L2.size());
        System.out.println("Linked Queue Iterator Test: ");
        Iterator<String> iterTest2 = L2.iterator();
        System.out.println("Linked Queue hasNext():" + iterTest2.hasNext());
        System.out.println("Linked Queue next(1): " + iterTest2.next());
        System.out.println("Linked Queue next(2): " + iterTest2.next());
        System.out.println("Linked Queue forEach Test: ");
        for(String temp : L2)
        {
            System.out.println(temp);
        }


        //CircularArrayQueue Tester

        System.out.println("Circular Array Queue isEmpty(1): " + L3.isEmpty());
        System.out.println("Circular Array Queue Enqueue L2: " + LN2 + LN1);
        //enqueue circulararrayqueue
        L3.enqueue(LN1);
        L3.enqueue(LN2);
        L3.enqueue(LN3);
        L3.enqueue(LN4);
        L3.enqueue(LN5);
        //test circulararrayqueue
        System.out.println("Circular Array Queue isEmpty(2): " + L3.isEmpty());
        System.out.println("Circular Array Queue Size = " + L3.size());
        System.out.println("Circular Array Queue toString: " + L3.toString());
        System.out.println("Circular Array Queue First: " + L3.first());
        Iterator<String> iterTest3 = L3.iterator();
        System.out.println("Circular Array Queue hasNext():" + iterTest3.hasNext());
        System.out.println("Circular Array Queue next(1): " + iterTest3.next());
        System.out.println("Circular Array Queue next(2): " + iterTest3.next());
        System.out.println("Circular Array Queue forEach Tester: ");
        for(String temp : L3)
        {
            System.out.println(temp);
        }
        System.out.println("Linked Stack Attempt remove(): ");
        //iterTest.remove();
        System.out.println("Linked Queue Attempt remove(): ");
        //iterTest2.remove();
        System.out.println("Circular Array Queue Attempt remove(): ");
        //iterTest3.remove();

    }
}
