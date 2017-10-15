import exceptions.*;

import java.util.*;


public class CircularArrayQueue<T> implements QueueADT<T>, Iterable<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;
    protected int modCount;
  
    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue (int initialCapacity)
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
        //set modcount to zero
        modCount=0;
    }
  
    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }    
	
	/**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    public void enqueue(T element)
    {
        if (size() == queue.length) 
            expandCapacity();
    
        queue[rear] = element;
        rear = (rear+1) % queue.length;
    
        count++;
        //adjust modCount in case of Iterator
        modCount++;
    }
	
	/**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
    
        for (int scan = 0; scan < count; scan++)
        {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
    
        front = 0;
        rear = count;
        queue = larger;
        //adjust modCount in case of Iterator
        modCount++;
    }
	
    /**
     * Removes the element at the front of this queue and returns a
     * reference to it. 
	 * @return the element removed from the front of the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
    
        T result = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;
    
        count--;
        //adjust modCount in case of Iterator
        modCount++;
    
        return result;
    }
  
    /** 
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        //I checked this time
        if(isEmpty())
            throw new EmptyCollectionException("You Suck");
        else
            return queue[front];
    }
  
    /**
     * Returns true if this queue is empty and false otherwise.
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
        //I'm Awesome
        return (count == 0);
    }
  
    /**
     * Returns the number of elements currently in this queue.
     * @return the size of the queue
     */
    public int size()
    {
        //these are Really Tiny
        return count;
    }
  
    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        String result = "";
        //iterate through all saved data in the queue
        int temp;
        ;
        for (temp = front ; temp<rear ; temp++)
        {
            result += queue[temp];
        }
        // return result......duh
        return result;
    }
    //returns inner iterator class on iterator call
    /*
        * pre Outer class is instantiated
        * post Creates an inner class instance of CircularArrayQueueIterator using the constructor
        * big(O) - 1
        * */
    public Iterator<T> iterator()
    {
        return new CicularArrayQueueIterator();
    }

    // inner iterator class with methods
    private class CicularArrayQueueIterator implements Iterator<T>
    {
        //create variables for use
        private int itMC, temp;
        //constructor links the current outer class modcount with the iterators own modcount
        // and creates a holder for the front index
        /*
        * pre Outer class is instantiated
        * post creates an inner class of CiruclarArrayQueueIterator and sets a temp pointer at the front index as well as syncs modcounts
        * big(O) -1
        * */
        public CicularArrayQueueIterator()
        {
            temp = front;
            itMC = modCount;
        }
        /*
        * pre Outer and inner classes are instantiated and have a next value from current temp variable stored
        * post returns true in iterator has a next value, throws an exception if not.
        * big(O) - 1
        * */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (itMC != modCount)
                throw new ConcurrentModificationException();

            return (queue[temp] != null);
            //This doesn't seem right but i can't figure out any other way to do it
        }
        /*
        * pre Outer and inner classes is instantiated and have a next value from current temp variable stored
        * post returns the next value and iterates through the Queue
        * big(O) - 1
        * */
        public T next() throws ConcurrentModificationException
        {
            T output = queue[temp];
            if (!hasNext())
                throw new NoSuchElementException();
            else
                temp++;
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
