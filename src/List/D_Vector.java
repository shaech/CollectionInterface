package List;

import java.util.*;

public class D_Vector {
    public void vectorDemo(){
        Vector<Integer> v1 = new Vector<>();
        v1.add(1);
        v1.add(2);

        List<Integer> l1 = new LinkedList<>(Arrays.asList(3,4,5,6));

        Vector<Integer> v2 = new Vector<>(l1);
        v1.addAll(l1);

        System.out.println("V1: " + v1);
        System.out.println("V2: " + v2);

        //you can add and check initial capacity and also give incremental capacity.

        Vector<String>v3 = new Vector<>(6,4);
        v3.add("1");
        v3.add("2");
        v3.add(String.valueOf(l1));   // this is a single object [3,4,5,6] hence add instead of addAll

        System.out.println("V3 is: " + v3);

        for(Integer i : l1){
            v3.add(String.valueOf(i));
        }

        System.out.println("New V3 is: " + v3);

        threadSync();
    }


    public void threadSync(){
        ArrayList<Integer> arrList = new ArrayList<>();  //=> any number 1654, 1799,2000, 1865 etc as not synchrinozed
        Vector<Integer> vectList1 = new Vector<>();  //result always 2000 as vector is synchronized

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 1000; i++) {
                arrList.add(i);
                vectList1.add(i);
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 1000; i++) {
                arrList.add(i);
                vectList1.add(i);
            }
        });

        t1.start();
        t2.start();

        try{
        t1.join();
        t2.join();}
        catch (InterruptedException ie) {ie.printStackTrace();}

        System.out.println("Array List size: " + arrList.size());
        System.out.println("Vector List size: " + vectList1.size());
    }

}
