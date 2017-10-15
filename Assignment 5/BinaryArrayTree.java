import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by BBaxter3160 on 2/28/2015.
 */
public class BinaryArrayTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    //declare package variables
    int root;
    final static int D_Size = 3;
    protected T[] mainArray;
    protected T[] transArray;
    int modCount;
    //base constructor for testing
    /*Pre: There is an array of size 1 or larger
    * post: There is now a BinaryArrayTree containing the aforementioned array
    * order: O(1)
     */
    public BinaryArrayTree(T[] newArray)
    {
        mainArray = newArray;
    }
    //constructor for new BinaryTreeArray with only one element
    /*Pre: There is an element
    * post: There is now a BinaryArrayTree containing the aforementioned element
    * order: O(1)
     */
    public BinaryArrayTree(T newRoot)
    {
        root = 0;
        mainArray = (T[]) new Object[D_Size];
        mainArray[root] = newRoot;
    }
    //constructor for combining two BinaryTreeArray objects
    /*Pre: There are two BinaryArrayTree's with valid array's contained within
    * post: There is now a BinaryArrayTree containing the aforementioned BinaryArrayTree's
    * order: O(n) where n is double the larger of the two arrays
     */
    public BinaryArrayTree(T newRoot, BinaryArrayTree<T> firstArray, BinaryArrayTree<T> secondArray)
    {
        //establish method variables
        int tempSize, level = 1, jPos = 0, lPos =0;
        //determine size of new array by doubling largest array
        if(firstArray.size() > secondArray.size())
            tempSize = firstArray.size() * 2 + 1;
        else
            tempSize = secondArray.size() * 2 + 1;
        //create array for combined data
        mainArray = (T[]) new Object[tempSize];
        //set root
        root = 0;
        mainArray[root] = newRoot;
        //combine two passed arrays into new main array
        //assumption of level ordered data as arrays being passed are of same object type.
        for(int i=1;i<tempSize;)
        {
            //left
            for(int j=jPos; j < level;j++)
            {
                //null check
                if(j< firstArray.mainArray.length)
                    mainArray[i++] = firstArray.mainArray[j];
                else//null handler
                    mainArray[i++] = null;

                jPos++;
            }
            //right
            for(int l = lPos; l<level;l++)
            {
                if(l<secondArray.mainArray.length)
                    mainArray[i++] = secondArray.mainArray[l];
                else
                    mainArray[i++] = null;

                lPos++;
            }
            level = 2 * level + 1;
        }
    }
    /*Pre: MainArray is instantiated with at least one element
        * post: returns the element at the root of the mainArray
        * order: O(1)
         */
    @Override
    public T getRootElement() {
        //simple
        return mainArray[root];
    }
    /*Pre: MainArray is instantiated
        * post: returns if the array is empty or not
        * order: O(1)
         */
    @Override
    public boolean isEmpty() {
        //simpler
        return mainArray.length > 0;
    }
    /*Pre: MainArray is instantiated with at least one element
        * post: returns the size of the array using array.length
        * order: O(1)
         */
    @Override
    public int size() {
        //simplest
        return mainArray.length;
    }
    /*Pre: MainArray is instantiated with at least one element
            * post: returns if the array contains the target element
            * order: O(n)
             */
    @Override
    public boolean contains(T targetElement) {
        //foreach iterates through array ignoring
        for(T temp : mainArray){
            //check for nulls
            if(temp != null){
                if(temp.equals(targetElement)){
                    return true;
                }
            }
        }
        return false;
    }
    /*Pre: MainArray is instantiated with at least one element
                * post: returns element if found or returns null
                * order: O(n)
                 */
    @Override
    public T find(T targetElement) {
        //same as contains
        for(T temp : mainArray){
            if(temp != null) {
                if (temp.equals(targetElement)){
                    return temp;
                }
            }
        }
        return null;
    }
    //all iterators use the same oneTwoTree method for organizing order
    @Override
    public Iterator<T> iterator() {
        return iteratorLevelOrder();
    }
    @Override
    public Iterator<T> iteratorPreOrder() {
        return new TreeArrayIterator(order(1,mainArray));
    }
    @Override
    public Iterator<T> iteratorInOrder() {
        return new TreeArrayIterator(order(2,mainArray));
    }
    @Override
    public Iterator<T> iteratorPostOrder() {
        return new TreeArrayIterator(order(3,mainArray));
    }
    /*Pre: MainArray is instantiated with at least one element and one of the iterator
            * post: Sets up a new int array and a holder array and starts the recursive loop
            * order: O(1)
             */
    public T[] order(int type, T[] array)
    {
        //create int array for storing oneTwoTree status
        int pass = 0;
        int[] oneTwoTree = new int[array.length];
        transArray = (T[])new Object[array.length];
        //call recursive loop
        return rLoop(pass,pass, type, array,oneTwoTree);
    }
    /*Pre: MainArray is instantiated with at least one element and order has been called by one of the iterators
            * post: returns if the array contains the target element
            * order: O(n)
             */
    public T[] rLoop(int count, int index, int type,T[] array, int[] oneTwoTree) {
        //increment holder for this position having been visited
        oneTwoTree[count]++;
        //check if increment holder matches the type of order we are looking for and if so transfer the object
        if (oneTwoTree[count] == type) {
            transArray[index++] = array[count];
        }
        //check for nulls
        if (array[count] != null) {
            //case for first visit go left.
            if (oneTwoTree[count] == 1 && array.length > 2 * count + 1) {

                rLoop((2 * count + 1), index, type, array, oneTwoTree);
            //case for second visit go right
            } else if (oneTwoTree[count] == 2 && array.length > 2 * (count + 1)) {

                rLoop((2 * (count + 1)), index, type, array, oneTwoTree);
            //case for third visit retreat back up the binary tree
            } else if (oneTwoTree[count] == 3 && (count - 1) / 2 >= 0) {

                rLoop((count - 1) / 2, index, type, array, oneTwoTree);
            //case for leafs encountered on 1st or 2nd visits
            } else if ((oneTwoTree[count] == 1 && array.length <= (2 * count + 1)) || (oneTwoTree[count] == 2 && array.length <= (2 * count) + 1)) {
                rLoop(count, index, type, array, oneTwoTree);
            }//case for retreat if on null hence past end leafs
        } else if ((index - 1) / 2 >= 0) {
            rLoop(((count - 1) / 2), index, type, array, oneTwoTree);
        }
        //returns the finished array after all recursive loops finished.
        return transArray;
    }
    /*Pre: MainArray is instantiated with at least one element
        * post: returns iterator of main array without any modification
        * order: O(1)
         */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        //returns the array in current form as it is stored in level order when not in use.
        return new TreeArrayIterator(mainArray);
    }
    private class TreeArrayIterator implements Iterator<T>
    {
        //private inner class
        private int expectedModCount, pos;
        private T[] iter;
        /*Pre: TreeArrayIterator has been called with a array of at least size 1
            * post: creates local array holder and sets up position counter
            * order: O(1)
             */
        public TreeArrayIterator(T[] temp)
        {
            pos=0;
            this.iter = temp;
            expectedModCount = modCount;
        }
        /*Pre: Iterator has been created and next() has been called
            * post: returns if the current array position in null
            * order: O(1)
             */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();

                return (iter[pos] != null);


        }
        /*Pre: Iterator has been created
            * post: returns current position and increments to the next array position
            * order: O(1)
             */
        public T next() throws NoSuchElementException
        {
            if (hasNext())
                return iter[pos++];
            else
                throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

}
