package com.company;

import com.company.exceptions.EmptyCollectionException;

public class LinkedDropOutStack<T> implements StackADT<T>
{
    private LinearNode<T> top;
    private static final int arbitraryNum=6;
    //arbitrary number for our n implementation
    public LinkedDropOutStack() {top = null;}

    @Override
    public void push(T element)
    {
        LinearNode<T>temp=new LinearNode<T>(element);
        temp.setNext(top);
        top=temp;

        //check to see if size is exceeding n and if so remove the bottom node.
        if(size()>=arbitraryNum){
            //if true calls drop method
            dropItLikeItsHot();
        }
    }
    /**
     * method for removing node from the bottom of the stack.
     */
    public void dropItLikeItsHot()
    {
        //create two node holders
        LinearNode<T> node=top;
        LinearNode<T> temp=top;
        //iterate through the stack until the bottom is reached.
        while(node.getNext()!=null)
        {
            temp=node;
            node=node.getNext();
        }
        //remove the reference to the bottom node
        temp.setNext(null);
        //garbage collection
        node=null;
    }
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();

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
        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        // check if top pointer points to null and therefore stack is empty
        if(top == null)
            return true;
        else
            return false;
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
}
