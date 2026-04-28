package List;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

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

    }
}