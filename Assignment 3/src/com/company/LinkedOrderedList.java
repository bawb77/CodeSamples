package com.company;

import com.company.exceptions.*;
/**
 * LinkedOrderedList represents a singly linked implementation of an 
 * ordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T> 
         implements OrderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList()
    {
        super();
    }
    /**
     * Adds the specified element to this list at the location determined by
	 * the element's natural ordering. Throws a NonComparableElementException 
	 * if the element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
	 */
    public void add(T element) throws NonComparableElementException
    {
        //cast a comparable version of the passed element
        Comparable<T> compEl = (Comparable<T>)element;
        LinearNode<T> tBP = new LinearNode<T>(element);
        if (isEmpty())
        {
            //create holder for the passed element
            //set all pointers if list is empty
            head = tail = tBP;
            //increment counters
            count++;
            modCount++;
        }
        else
        {
            //set head and head-1 holders
            LinearNode<T> current = head;
            LinearNode<T> previous = null;
            //check to make sure element is comparable
            if(!(element instanceof Comparable))
                throw new NonComparableElementException("LinkedOrderedList");
            //iterate through the list head to tail while current element is less than target element
            while(current != null && compEl.compareTo(current.getElement()) >= 0)
            {
                //iterate
                previous = current;
                current = current.getNext();
            }
            //add the element in front of the current element that is greater than it.
            previous.setNext(tBP);
            tBP.setNext(current);
            //check to take care of tail
            if(current == null)
                tail = tBP;
        }
        //increment counters
        count++;
        modCount++;
    }
}
