package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class C_LinkedList {

    /*Implementation of linkedlist behaving as list.
    * If we write List<String> l1 = new LinkedList<>();
    * its valid but it will not have methods of say getFirst, addLast, etc.
    * */


    public void linkk() {
        LinkedList<String> l1 = new LinkedList<>();
        l1.add("Apple");
        l1.add("Banana");
        l1.add("Cherry");
        l1.add("Dates");
        l1.add("ExoticApple");
        l1.add("Fig");
        l1.add("Grapes");

        LinkedList<String> toRemovee = new LinkedList<>(Arrays.asList("ExoticApple","Fig"));

        System.out.println("L1 added: " + l1);
        l1.removeAll(toRemovee);
        System.out.println("L1 to remove: " + l1);



        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(5);

        System.out.println("First element at index 1 : "+l2.get(1));  //O(n)

        l2.add(6);
        l2.addLast(7);
        l2.addFirst(8);

        System.out.println("First: "+l2.getFirst());
        System.out.println("Last: "+l2.getLast());

        System.out.println("Before Anything? " + l2);
        l2.remove();    //removes 1st element if no index is given.
        System.out.println("After Anything? " + l2);

        l2.removeIf(x -> x%2 == 0 );

        System.out.println(l2);

    }
}
