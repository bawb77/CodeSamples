/**
 * Created by BBaxter3160 on 3/12/2015.
 */
public class BinaryArraySearchTree<T> extends BinaryArrayTree<T> implements BinarySearchTreeADT<T> {


    public BinaryArraySearchTree(T[] newArray) {
        super(newArray);
    }
    //constuctor accepting single new root
    public BinaryArraySearchTree(T newRoot) {
        super(newRoot);
    }

    /*Pre: BinaryArraySearchTree exists
    * post: BinaryArraySearchTree exists and has at least one element in it
    * order: O(log2n)
     */
    @Override
    public void addElement(T element) {
        //set tripwire
        boolean run= true;
        //create object to preform comparisons
        Comparable<T> compEl = (Comparable<T>)element;
        //holder for place in array
        int curr = 0;
        while(run)
        {
            //check if we are already at a empty leaf and them add if true
            if(mainArray[curr] == null) {
                mainArray[curr] = element;
                //exit the loop
                run = false;
            }else{
                //get comparison value between two objects
                int compTemp = compEl.compareTo(mainArray[curr]);
                //logic for comparison
                if(compTemp >= 0 && 2*(curr + 1) < mainArray.length)
                    curr = goRight(curr);
                else if(compTemp == -1 && (2*curr) + 1 < mainArray.length)
                    curr = goLeft(curr);
                else
                //expand the array if no available leaf to put object in
                    expTheArray();
            }
        }
    }
    /*Pre: int
    * post: int incremented for right child
    * order: O(1)
     */
    //duh
    public int goRight(int in)
    {
        return  2*(in+ 1);
    }
    /*Pre: int
    * post: int incremented for left child
    * order: O(1)
     */
    //duh2
    public int goLeft(int in)
    {
        return (2*in) + 1;
    }
    /*Pre: array
    * post: array with one extra place
    * order: O(n)
     */
    //method to expand the array
    public void expTheArray()
    {
        //create new array that is one bigger than the previous array
        T[] expArray = (T[]) new Object[mainArray.length + 1];
        //transfer data between arrays
        for(int i = 0 ; i <  mainArray.length ; i++)
        {
           expArray[i] = mainArray[i];
        }
        //shift pointers
        mainArray = expArray;
    }
    /*Pre: BinaryArraySearchTree with at least one element in it
        * post:BinaryArraySearchTree with offending element removed
        * order: O(log2n)
         */
    @Override
    public T removeElement(T targetElement) {
        //find elements location in the array
        int location = findElement(targetElement);
        // check if left child exists
        if(goLeft(location) >= mainArray.length)
            //if left child doesn't exist remove current element
            mainArray[location] = null;
        //check if left child is null
        else if(mainArray[goLeft(location)] != null) {
            //if left child is not null continue going deeper in the tree
            mainArray[location] = removeElement(mainArray[goLeft(location)]);
        //check if the right child is within the array
        }else if(goRight(location) < mainArray.length ) {
            //check if the right child is null
            if(mainArray[goRight(location)] != null)
                //if child is not null continue going deeper in the tree
                mainArray[location] = removeElement(mainArray[goRight(location)]);
            else
                //if right child is null remove the current element
                mainArray[location] = null;
        }
        //return the element removed
        return targetElement;
    }
    /*Pre:BinaryArraySearchTree with at least one element
    * post:the position in array of the request element
    * order: O(log2n)
     */
    public int findElement(T targetElement){
        //set up variables
        int i =0, result = 0;
        boolean run = true;
        //create comparable object
        Comparable<T> compEl = (Comparable<T>)targetElement;
        //start loop
        while(run)
        {
            //get comparable int value for logic processing
            int compTemp = compEl.compareTo(mainArray[i]);
            //if less than
            if (compTemp == -1)
                i = goLeft(i);
            //if greater than
            else if (compTemp == 1)
                i = goRight(i);
            //if equal
            else if (compTemp == 0)
            {
                //check result to make sure there are no duplicates further down the tree
                result = findSame(i);
                //exit loop
                run = false;}
        }
        return result;
    }
    /*Pre: location of element that may have duplicates
    * post: location of duplicate on the lowest level of the tree
    * order: O(log2n)
     */
    public int findSame(int in)
    {
        //set up comparable object
        Comparable<T> compEl = (Comparable<T>)mainArray[in];
        //check if right child is within the array
        if(goRight(in) < mainArray.length )
            //check if right child is null
            if(mainArray[goRight(in)] != null)
                //check if right child is the same as parent
                if (compEl.compareTo(mainArray[goRight(in)])==0)
                    //recursive call until reach the end of the duplicates
                    in = findSame(goRight(in));
        //return the position of the last duplicate
        return in;
    }
    /*Pre:BinaryArraySearchTree with at least one element
        * post: BinaryArraySearchTree without all occurances of the offending element
        * order: O(nlog2n)
         */
    @Override
    public void removeAllOccurrences(T targetElement) {
        //create comparable object
        Comparable<T> compEl = (Comparable<T>)targetElement;
        for(int i = 0; i < mainArray.length;)
        {
            //check if current element is null
            if(mainArray[i] != null){
                //if current element not null check for a match
                if(compEl.compareTo(mainArray[i]) == 0)
                    //if matched remove the element from the array
                    removeElement(mainArray[i]);
                else
                    //or continue iterating through the array looking for matches
                    i++;
            }
            else
                //or continue iterating through the array looking for matches
                i++;

        }
    }
    /*Pre: BinaryArraySearchTree with at least one element
        * post:
        * order: O(n)
         */
    @Override
    //super easy
    public T removeMin() {
        return removeElement(findMin());
    }
    /*Pre:BinaryArraySearchTree with at least one element
        * post:min element is removed
        * order: O(n)
         */
    @Override
    //super easy
    public T removeMax() {
        return removeElement(findMax());
    }
    /*Pre:BinaryArraySearchTree with at least one element
        * post: max element removed
        * order: O(n)
         */
    @Override
    public T findMin() {
        //set up variables
        int curr = 0, previous = 0;
        boolean run = true;
        T temp = null;
        //start loop
        while(run)
        {
            //check if current is null
            if(mainArray[curr] != null)
            {
                //if current is not null progress to the next left child
                previous = curr;
                curr = goLeft(curr);
            }
            else
            {
                //if current child is null return it's parent
                temp = mainArray[previous];
                //exit the loop
                run = false;
            }

        }
        //return the min
        return temp;
    }
    /*Pre:BinaryArraySearchTree with at least one element
        * post: max element removed
        * order: O(n)
         */
    @Override
    public T findMax() {
        //set up variables
        int curr = 0, previous = 0;
        boolean run = true;
        T temp = null;
        //start loop
        while(run)
        {
            //check if current is null
            if(mainArray[curr] != null)
            {
                //if current is not null progress to the next right child
                previous = curr;
                curr = goRight(curr);
            }
            else
            {
                //if current child is null return the parent
                temp = mainArray[previous];
                //exit the loop
                run = false;
            }

        }
        //return the max
        return temp;
    }
}
