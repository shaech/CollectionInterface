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

    public void hashMapEg(){
        HashMap<String,Integer> fruitMap  = new HashMap<>();

        fruitMap.put("Apple",9);
        fruitMap.put("Banana",9);
        fruitMap.put("Orange",9);
        fruitMap.put("Grape",9);

//        index = hashCode % arraySize;
//Assuming hashCode = 10832233  and default sie is 16,  10832233 % 16  = 9
//   So, Apple will be stored in bucket 9


        //Assuming orange and grape  has same hashcode output 14, linkedlist will come  - collision
        //TREEIFY_THRESHOLD = 8 in hashmap - default.. here only 2, so linkedlist.  if on 14, 8 linkedlist nodes comes, it will be treeified

        fruitMap.get("Grape");
        fruitMap.getOrDefault("Grape",-1);
        fruitMap.putIfAbsent("Mangoes",1);

        //in linkedlist, it traverses and checks whether kep is grape using equals() method.




    }


    public void marks(){

        Studentt s1 = new Studentt();
        Studentt s2 = new Studentt();
        Studentt s3 = new Studentt();
        // Studentt s4 = new Studentt("Ram",1);
        Studentt  s4 = new Studentt();
        s1.setName("Ram");
        s1.setId(1);

        s2.setName("Shyam");   // should need new object or Shyam will replace Ram in s1.
        s2.setId(2);

        s3.setName("Ghanshyam");
        s3.setId(4);

        s4.setName("Ram");
        s4.setId(1);

        HashMap<Studentt,Integer> marksMap = new HashMap<>();

        marksMap.put(s1,85);
        marksMap.put(s2,80);
        marksMap.put(s3,77);
        marksMap.put(s4,90);    // this is getting replaced. So ram will now have 90 marks -> check map

        for(Map.Entry<Studentt,Integer> val : marksMap.entrySet()) {
            System.out.println("***********");
            System.out.println("MarksMap key name is: " + val.getKey().name);    //should not be allowed - make field private in Studentt and used getter like below
            System.out.println("MarksMap key id is: " + val.getKey().getId());
            System.out.println("MarksMap value marks is: " + val.getValue());

        }

        System.out.println("Although, hashmap size is still 4 as hashcodes " +
                "are same but index is diff. \n So we override generated hashcode" +
                " and equals methods: \n Size before overriding is 4.  Size post overriding is 3:  "+marksMap.size());


        //ToString Method Override:


        //=> Before Overriding toString:
        // HashCode: 2540420
        //Hash.Studentt@26c384

        System.out.println(s1);

        //After overriding toString() in Studentt.java class in generate methods,
        //Studentt{name='Ram', id=1}

    }

}
