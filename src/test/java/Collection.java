

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Collection {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4};

        System.out.println(a[0]);
        a[3] = 34;
        //a[4] = 234;

        System.out.println(a.length);

        ArrayList<Integer> aList = new ArrayList<Integer>(10);

        System.out.println(aList.size());

       //add new elements
        for(int i=0;i<20;i++){
            aList.add(i);
        }

        aList.add(21, 21);

        //print the arraylist
        for(int i=0;i<aList.size();i++){
            System.out.println("printing");
            System.out.println(aList.get(i));
        }

        Iterator<Integer> itr = aList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        HashSet<String> hSet = new HashSet<String>();

        hSet.add("Simion");
        hSet.add("Assel");
        hSet.add("Simion");

        Iterator<String> itrs = hSet.iterator();
        while(itrs.hasNext()){
            System.out.println(itrs.next());
        }











    }
}
