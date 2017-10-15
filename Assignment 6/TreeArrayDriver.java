import java.util.Iterator;

/**
 * Created by BBaxter3160 on 3/1/2015.
 */
public class TreeArrayDriver {
    public static void main(String[] args)
    {
        Integer root = 5;
        BinaryArraySearchTree<Integer> test1 = new BinaryArraySearchTree<Integer>(root);

        test1.addElement(2);
        test1.addElement(7);
        test1.addElement(3);
        test1.addElement(1);
        test1.addElement(6);
        test1.addElement(8);
        test1.addElement(3);
        test1.addElement(9);
        Iterator<Integer> iter = test1.iteratorInOrder();
        System.out.println("Creation TEST");
        for(int i =0 ; i < test1.size();i++)
        {
            System.out.print(iter.next() + ", ");
        }
        test1.removeElement(9);
        Iterator<Integer> iter2 = test1.iteratorInOrder();
        System.out.println("\nRemoval TEST");
        for(int i =0 ; i < test1.size();i++)
        {
            System.out.print(iter2.next() + ", ");
        }
        test1.removeAllOccurrences(3);
        Iterator<Integer> iter3 = test1.iteratorInOrder();
        System.out.println("\nRemoveAll TEST");
        for(int i =0 ; i < test1.size();i++)
        {
            System.out.print(iter3.next() + ", ");
        }
        test1.addElement(3);
        Iterator<Integer> iter4 = test1.iteratorInOrder();
        System.out.println("\nFinal Array for TEST ");
        for(int i =0 ; i < test1.size();i++)
        {
            System.out.print(iter4.next() + ", ");
        }
        System.out.println("\nFind Min: " + test1.findMin());
        System.out.println("Find Max: " + test1.findMax());
        System.out.println("Remove Min and Max");
        test1.removeMax();
        test1.removeMin();
        Iterator<Integer> iter5 = test1.iteratorInOrder();
        System.out.println("Array with max and min removed");
        for(int i =0 ; i < test1.size();i++)
        {
            System.out.print(iter5.next() + ", ");
        }
        test1.addElement(1);
        test1.addElement(8);
        System.out.println("\nRe-add 1 and 8");
        System.out.println("\nTriangle Printing\n");

        int levels = (int)Math.ceil((Math.log10(test1.size()) / Math.log10(2)));
        int levelcounter = 1;
        Iterator<Integer> iterTri = test1.iteratorLevelOrder();
        for(int i =0 ; i < test1.size();i++)
        {
            int j = 0;
            while(j<levels)
            {
                System.out.print(" ");
                j++;
            }
            int k = 0;
            while(k<levelcounter && Math.pow(2,levels) >= levelcounter / 4)
            {
                System.out.print(iterTri.next() + " ");
                k++;
            }
            levelcounter *= 2;
            System.out.println("");
            levels--;

        }
    }

}
