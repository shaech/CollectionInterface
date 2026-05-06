package List;

import java.util.LinkedList;
import java.util.Stack;

public class E_Stack {
    public void stackDemo(){

        Stack<Integer> s1 = new Stack<>();
        //Pushing values in int stack
        s1.push(2);
        s1.push(3);

        int[] a1 = new int[]{4,5,6,7,8,9,10};

        for(int a : a1){
            s1.push(a);
        }

        System.out.println("Stack is: " + s1);


        //Peek - top element

        System.out.println("Peek - top element is: " + s1.peek());

        //Search

        System.out.println("Size of stack: " + s1.size());

        System.out.println("Search 3  (stack.size-3): " +  s1.search(3 ));
        System.out.println("Search: " +  s1.search(s1.size()));   // will search top - s1.size
        System.out.println("Capacity: "+s1.capacity());


    }

}
