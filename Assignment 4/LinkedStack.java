import exceptions.*;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations 
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T>, Iterable<T>
{
    private LinearNode<T> top;
    protected int modCount;

    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        top = null;
        modCount =0;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        modCount++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
        modCount++;
 
        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty  
     */
    public T peek() throws EmptyCollectionException
    {
        //Returns the data from the top Node
        if(isEmpty())
            throw new EmptyCollectionException("Stack is Empty");
      return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        // check if top pointer points to null and therefore stack is empty
        return top == null;
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        // checks for Empty first and returns zero size if true
        if(isEmpty())
            return 0;
        //create Temporary node
        LinearNode<T> node = top;
        int c = 0;
        //Iterate Through the Stack to get a Size count.
        while(node != null)
        {
            c++;
            node = node.getNext();
        }
        //Return size Count
        return c;
    }

    /**
     * Returns a string representation of this stack. 
     * @return string representation of the stack
     */
    public String toString()
    {
       String temp ="";
       LinearNode<T> node = top;
        //Iterates through the Stack, Concatenating all the data into a single string variable temp.
       while(node != null)
       {
           temp += node.getElement();
           node = node.getNext();
       }
        //returns the concatenated string
        return temp;
    }
    //returns inner iterator class on iterator call
    /*
    * pre  LinkedStack already exists
    * post Create an LinkedStackIterator Class for using with iterable commands
    * big(O) - 1
    * */
    public Iterator<T> iterator()
    {
        return new LinkedStackIterator();
    }

    // inner iterator class with methods
    private class LinkedStackIterator implements Iterator<T>
    {
        //create variables for use
        private LinearNode<T> temp;
        private int itMC;
        //constructor links the current outer class modcount with the iterators own modcount
        // and creates a holder for the top
        /*
        * pre LinkedStack outer class exists
        * post Instance of LinkedStackIterator is created and modcounts are synced as well as pointing temp to top
        * big(O) - 1
        * */
        public LinkedStackIterator()
        {
            temp = top;
            itMC = modCount;
        }
        /*
        * pre Outer and inner classes is instantiated and have a next value from current temp variable stored
        * post returns true if there exists a next node and throws an error message if there is not
        * big(O) - 1
        * */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (itMC != modCount)
                throw new ConcurrentModificationException();

            return (temp != null);
            //This doesn't seem right but i can't figure out any other way to do it
        }
        /*
        * pre Outer and inner classes is instantiated and have a next value from current temp variable stored
        * post returns the element stored in the next node and iterates to the next item in the stack or throws an exception if element does not exist
        * big(O) - 1
        * */
        public T next() throws ConcurrentModificationException
        {
            T output = temp.getElement();
            if (!hasNext())
                throw new NoSuchElementException();
            else
                temp = temp.getNext();
            return output;
        }
        /*
        * pre Outer and inner classes is instantiated
        * post Simply calls an Exception on any attempted remove.
        * big(O) - 1
        * */
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }
}
