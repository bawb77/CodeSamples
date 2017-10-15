import java.util.Iterator;

/**
 * Created by BBaxter3160 on 3/1/2015.
 */
public class TreeArrayDriver {
    public static void main(String[] args)
    {
        Integer num1 = 0;
        BinaryArrayTree test1 = new BinaryArrayTree(num1);
        System.out.println("Size 1: " + test1.size());
        Integer[] testArray1 = new Integer[]{1,
                                    11,12,
                                    111,112,121,122};
        Integer[] testArray2 = new Integer[]{2,
                                            21,22,
                                            211,212};
        BinaryArrayTree test2 = new BinaryArrayTree(testArray1);
        System.out.println("Size 2: " + test2.size());
        BinaryArrayTree test3 = new BinaryArrayTree(testArray2);
        System.out.println("Size 3: " + test3.size());

        BinaryArrayTree test4 = new BinaryArrayTree(num1,test2,test3);
        System.out.println("Size 4: " + test4.size());
        System.out.println("4 isEmpty: " + test4.isEmpty());
        System.out.println("4 getRoot: " + test4.getRootElement());
        System.out.println("Contains 2: " + test4.contains(2));
        System.out.println("Contains 5: " + test4.contains(5));
        System.out.println("Find 2: " + test4.find(2));
        System.out.println("Find 5: " + test4.find(5));
        for(int i =0;i<test4.size();i++)
        {
            System.out.println("Position " + i + ": " + test4.mainArray[i]);
        }
        Iterator < Integer > inTemp = test2.iteratorInOrder();

        for(int i=0; i < test2.size(); i++)
        {
            System.out.println("In iter: " + inTemp.next());
        }
        Iterator<Integer> levelTemp = test2.iteratorLevelOrder();

        for(int i=0; i < test2.size(); i++)
        {
            System.out.println("Level iter: " + levelTemp.next());
        }
        Iterator<Integer> preTemp = test2.iteratorPreOrder();

        for(int i=0; i < test2.size(); i++)
        {
            System.out.println("Pre iter: " + preTemp.next());
        }
        Iterator<Integer> postTemp = test2.iteratorPostOrder();

        for(int i=0; i < test2.size(); i++)
        {
            System.out.println("Post iter: " + postTemp.next());
        }
    }
}
