/**
 * Created by BBaxter3160 on 3/12/2015.
 */
public class BinaryArraySearchTree<T> extends BinaryArrayTree<T> implements BinarySearchTreeADT<T> {


    public BinaryArraySearchTree(T[] newArray) {
        super(newArray);
    }

    public BinaryArraySearchTree(T newRoot) {
        super(newRoot);
    }

    @Override
    public void addElement(T element) {
        boolean run= true;
        Comparable<T> compEl = (Comparable<T>)element;
        int curr = 0;
        while(run)
        {
            if(mainArray[curr] == null) {
                mainArray[curr] = element;
                run = false;
            }else{
                int compTemp = compEl.compareTo(mainArray[curr]);
                if(compTemp >= 0 && 2*(curr + 1) < mainArray.length)
                    curr = goRight(curr);
                else if(compTemp == -1 && (2*curr) + 1 < mainArray.length)
                    curr = goLeft(curr);
                else
                    expTheArray();
            }
        }
    }
    public int goRight(int in)
    {
        return  2*(in+ 1);
    }
    public int goLeft(int in)
    {
        return (2*in) + 1;
    }
    public void expTheArray()
    {
        T[] expArray = (T[]) new Object[mainArray.length + 1];
        for(int i = 0 ; i <  mainArray.length ; i++)
        {
           expArray[i] = mainArray[i];
        }
        mainArray = expArray;
    }

    @Override
    public T removeElement(T targetElement) {
        int location = findElement(targetElement);

        if(goLeft(location) >= mainArray.length)
            mainArray[location] = null;

        else if(mainArray[goLeft(location)] != null) {
            mainArray[location] = removeElement(mainArray[goLeft(location)]);

        }else if(goRight(location) < mainArray.length ) {
            if(mainArray[goRight(location)] != null)
                mainArray[location] = removeElement(mainArray[goRight(location)]);
            else
                mainArray[location] = null;
        }
        return targetElement;
    }
    public int findElement(T targetElement){
        int i =0, result = 0;
        boolean run = true;
        Comparable<T> compEl = (Comparable<T>)targetElement;
        while(run)
        {
            int compTemp = compEl.compareTo(mainArray[i]);
            if (compTemp == -1)
                i = goLeft(i);
            else if (compTemp == 1)
                i = goRight(i);
            else if (compTemp == 0)
            {   result = findSame(i);run = false;}
        }
        return result;
    }
    public int findSame(int in)
    {
        Comparable<T> compEl = (Comparable<T>)mainArray[in];
        if(goRight(in) < mainArray.length )
            if(mainArray[goRight(in)] != null)
                if (compEl.compareTo(mainArray[goRight(in)])==0)
                    in = findSame(goRight(in));

        return in;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        Comparable<T> compEl = (Comparable<T>)targetElement;
        for(int i = 0; i < mainArray.length;)
        {
            if(mainArray[i] != null){
                if(compEl.compareTo(mainArray[i]) == 0)
                    removeElement(mainArray[i]);
                else
                    i++;
            }
            else
                i++;

        }
    }

    @Override
    public T removeMin() {
        return removeElement(findMin());
    }

    @Override
    public T removeMax() {
        return removeElement(findMax());
    }

    @Override
    public T findMin() {
        int curr = 0, previous = 0;
        boolean run = true;
        T temp = null;
        while(run)
        {
            if(mainArray[curr] != null)
            {
                previous = curr;
                curr = goLeft(curr);
            }
            else
            {
                temp = mainArray[previous];
                run = false;
            }

        }
        return temp;
    }

    @Override
    public T findMax() {
        int curr = 0, previous = 0;
        boolean run = true;
        T temp = null;
        while(run)
        {
            if(mainArray[curr] != null)
            {
                previous = curr;
                curr = goRight(curr);
            }
            else
            {
                temp = mainArray[previous];
                run = false;
            }

        }
        return temp;
    }
}
