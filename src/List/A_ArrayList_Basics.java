package List;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_ArrayList_Basics {

    public void createArrayList(){

        int[] s_arr = new int[10];  //static array
        //List<Integer> d_arr = new ArrayList<>();
        ArrayList<Integer> d_arr = new ArrayList<>();
        d_arr.add(20);
        d_arr.add(40);
        d_arr.add(60);
        d_arr.add(80);
        System.out.println("Get: "+d_arr.get(1));
        System.out.println("Size: " + d_arr.size());

        for(int i : d_arr ){
            System.out.println("Value: " + i);
            //i = 20; means d_arr.get(i) gives value at 20th index - out of bounds.

        }

        //If you need position and values → use for loop
        //If you need just values as it doesn't give position → use for-each

        for(int i=0; i<d_arr.size(); i++){
            System.out.println("Index: " +  i + " has value: " + d_arr.get(i));
        }


        //check existence of number
        System.out.println("Exist 20: " + d_arr.contains(20));
        System.out.println("Exist 50: " + d_arr.contains(50));

        // remove elements
        d_arr.remove(1);

        //adding at specific element

        d_arr.add(2,150);

        for(int x: d_arr){
            System.out.println("Post remove and addition - cascade: "+x);
        }


        d_arr.set(2,100);

        for(int x: d_arr){
            System.out.println("Post set: removal of value at index and set new one : "+x);
        }

//        without loop print:

        System.out.println(d_arr.toString());


        ArrayList<Integer> list = new ArrayList<>(1000);
        System.out.println("List size: will be 0 as 1000 is capacity: " + list.size());
        //System.out.println("get will be null - out of bonds on get(0) " + list.get(0));

        //Here array will resize at 1001th element to 1.5x the size.

        try {

            //REFLECTIVE - BREAKS ENCAPSULATION - NOT RECOMMENDED IN PRODUCTION.
            // NOT ALLOWED IN Java 9+ - but still to try, add this in VM options:  --add-opens java.base/java.util=ALL-UNNAMED
            //To know capacity - reflect is used.
            Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(d_arr);
            System.out.println("ArrayList Capacity: " + elementData.length);
            System.out.println("Arraylist size: " + d_arr.size());

            d_arr.add(11);d_arr.add(11);d_arr.add(11);d_arr.add(11);d_arr.add(11);d_arr.add(11);d_arr.add(11);

            System.out.println("New Arraylist size: " + d_arr.size());
            elementData = (Object[]) field.get(d_arr);
            System.out.println("ArrayList Capacity: " + elementData.length);

            //Here capacity is 10.till size = 10.. no chnge
            //when addedd 11th element, capcacity changed to 15 and size as 11.


            // on removing, capacity doesn't go away automatically.
            d_arr.trimToSize();  // will do shrinking to capacity..

            System.out.println("Trim Arraylist size: " + d_arr.size());
            elementData = (Object[]) field.get(d_arr);
            System.out.println("Trim ArrayList Capacity: " + elementData.length);


        } catch (Exception e){e.printStackTrace();}


        // This is static array. You can replce items but you can't add or remove.
        List arr = Arrays.asList(1,3,"Heya");
        System.out.println("AsList: " + arr.getClass().getName());
        System.out.println("on the fly  asList: "+ arr);

        arr.set(2,5);   //allowed

        //arr.remove(1);  - not allowed
        //arr.add(2);  - not allowed

        System.out.println("on the fly  asList: "+ arr);


        //Unmodified List - can't use arr.set() too. immutable
        List<Integer> unmodList = List.of(1, 26, 4, 46, 689);
        System.out.println("Unmodified List: " + unmodList);

        List<? extends Serializable> unmodList2 = List.of("r", "gt", 2, true, "48", 48);
        System.out.println("Unmodifia ble complex" + unmodList2);


        //List.of and then it copies to new arrayList so it is mutabled
        List<String> list1 = new ArrayList<>(List.of("Apple","Banana","Cherry"));
        list1.add("DragonFruit");
        System.out.println("List is: " + list1);

        List<String> list2 = new ArrayList<>(5);   //capacity

        List<String> list3 = new ArrayList<>(list1);
        list3.add("Exotic Apple");
        System.out.println("My new list 3: " + list3);


        System.out.println("My fav is: " + list1.get(2));

        List<Integer> list4 = new ArrayList<>(List.of(6,5,4,3,2,1));
        List<Integer> list5 = new ArrayList<>(list4);

        //Now, if you do remove as below
        list3.remove("DragonFruit");    //it removes by finding value
        System.out.println("Removed value: "+list3);


        System.out.println("..........IMP CAN COME HANDY WHEN DEALING ONLY WITH INTEGERS.......");
        list4.remove(2);   //WHAT WILL IT REMOVE? It is automatically taking index.. hence value 4
       //so to get object we do this,
        System.out.println("Removed value at index 2: "+list4);

        list5.remove(Integer.valueOf(2));
        System.out.println("Removed value 2: " + list5);

  // We can also move from list to Array

//        since no datatype is given, it will introduce variable as Object.
        Object[] array = list5.toArray();
        //we can give datatype  list5.toArray(new Integer[0]);
        Integer[] array1 = list5.toArray(new Integer[0]);
        //list1.toArray(new String[0]);   //Datatype [sqrbracket] and starting 0 in sqrbracket
        String[] array2 = list1.toArray(new String[0]);

        //Sorting
        Collections.sort(list1);

//        can be simplified to =>
        list1.sort(null);   //null passed cz it needs to compare with something. Open definition

        //Time complexity O(n)
    }

}
