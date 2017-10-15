package com.company;

import com.company.exceptions.*;

/**
 * LinkedUnorderedList represents a singly linked implementation of an 
 * unordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedUnorderedList<T> extends LinkedList<T> 
         implements UnorderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList()
    {
        super();
    }
    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToFront(T element)
    {
        //create new linearnode holder for passed data
        LinearNode<T> temp = new LinearNode<T>(element);
        //insert new node at the head of the list
        temp.setNext(head);
        head = temp;
        //check to make sure tail has been assigned and if not
        if(tail == null)
            tail = temp;
        //increment counts
        modCount++;
        count++;
    }
	/**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToRear(T element)
    {
        //create new linearnode holder for passed data
        LinearNode<T> temp = new LinearNode<T>(element);
        //check if isEmpty and normalize head tail if so
        if(isEmpty())
            head = tail = temp;
        else
        {
            //add to the end of the list
            if(tail != null)
            tail.setNext(temp);
            tail = temp;
        }
        //increment counts
        modCount++;
        count++;
    }
    /**
     * Adds the specified element to this list after the given target.
     *
     * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
    public void addAfter(T element, T target) throws EmptyCollectionException, ElementNotFoundException
    {
        //check isEmpty
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        //boolean for finding the target element
        boolean found = false;
        //create temp head holder and linearNode for passed data
        LinearNode<T> current = head;
        LinearNode<T> newGuy = new LinearNode<T>(element);
        //while we have not reached the end of the list and the matching element boolean has not been switched
        while (current != null && !found)
            if (target.equals(current.getElement()))
            {
                //check for end of list
                if(current.getNext() == null)
                    tail = newGuy;
                //insert passed element after target element
                newGuy.setNext(current.getNext());
                current.setNext(newGuy);
                //change find boolean
                found = true;
                //increment counters
                modCount++;
                count++;
            }
            else
            {
                //continue to iterate through the list
                current = current.getNext();
            }
        //if the target element is not found throw exception.
        if (!found)
            throw new ElementNotFoundException("LinkedList");
    }	
}
