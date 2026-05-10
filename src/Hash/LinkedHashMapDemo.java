package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    //method have to be public as package is different
    public void linkedMap() {
        LinkedHashMap<Integer, Integer> lmp = new LinkedHashMap<>();
        HashMap<Integer,Integer> lmp1 = new HashMap<>(5,2);  //INSERTION ORDER IS NOT MAINTAINED
        LinkedHashMap<Integer, Integer> lmp2 = new LinkedHashMap<>(5,2,true);  //INSERTION ORDER MAINTAINED

         //access order true false to see if values are in insertion order.. ctrl+ b => go to definition of LinkedHashMap to check.
         // this will work with get()  or getOrDefault().
         // so if accessOrder is TRUE,  THE ONE THAT IS ACCESSED WILL MOVE TO THE END OF LIST
        // This is called LRU algo = Least Recently Used Element.

        int[] a1 = new int[]{1,2,3,4,5,6,7,8,9,10};

        for(int lmap : a1){
            lmp.put(lmap,lmap);
            lmp1.put(lmap,lmap);
            lmp2.put(lmap,lmap);
        }

        System.out.println("LMP: " + lmp);
        System.out.println("LMP 1: " + lmp1);
        System.out.println("LMP 2: " + lmp2);

        lmp2.get(6);

        System.out.println("Access order true 6 moved at end : LMP 2: " + lmp2);   // 6 will go at end

        lmp2.getOrDefault(15,-1);
        lmp2.putIfAbsent(4,5); //  here 4 key is already there. so 4 value will not be replaced by value 5. but since its accessed, it will come later in LinkedHashMa if access is true.
        lmp2.putIfAbsent(13,13);

        System.out.println("Access order true 6 moved at end : LMP 2: " + lmp2);

    }

}
