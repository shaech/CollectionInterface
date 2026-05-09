package Hash;

import java.util.*;

public class HashMapp {

    public void hashmapDemo(){
        //we can give initial capacity and load factor too...
        HashMap<Integer, String> hm = new HashMap<>(18,0.5f);

        List<String> l1 = new LinkedList<>(List.of("a","b","c","d"));

        int i = 0;
        for(String s1 : l1){

            hm.put(i,s1);
            i++;
        }

        System.out.println("HashMap is: " + hm);


        // To print values based on key
        for(int j : hm.keySet()){
            System.out.println(hm.get(j));
        }

        System.out.println(" Individual print: "+hm.get(2));

        for(Map.Entry<Integer,String> ent : hm.entrySet()){
            System.out.println("Key only passed: " + ent.getKey() + "..."  + ent.getValue());
        }


        //no for loop in set cz we are just giving entries.
        Set<Map.Entry<Integer,String>> interf = hm.entrySet();

        for(Map.Entry<Integer,String> k : interf){

            //set values = modifications possible here
            k.setValue(k.getValue().toUpperCase());

            System.out.println("Key-Value passed: " + k.getKey() + ".... " + k.getValue());

        }

    }

}
