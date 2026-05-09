package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashFunc {

    public int simpleHash(String key){
         int sum = 0;
         for(char c: key.toCharArray()){
             System.out.println("C is: " + c);
             sum += (int) c;
             System.out.println(" Sum: " + sum);
         }
        System.out.println("Final sum : " + sum);
         return sum % 10;
    }


    public void moreLoadFactorTry(){
        HashMap<Integer,Integer> h1 = new HashMap<>();
        HashMap<Integer,Integer> h2 = new HashMap<>(5,0.5f);
        HashMap<Integer,Integer> h3 = new HashMap<>(5,3);

        int[] a1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12};

        for(int i : a1) {
            h1.put(i,i);
        }

        for(int i : a1) {
            h2.put(i,i);
        }

        for(int i : a1) {
            h3.put(i,i);
        }


        System.out.println("H1 is: " + h1);
        System.out.println("H2 is: " + h2);
        System.out.println("H3 is: " + h3);   // here the order gets changed. so something is happenning at the back


    }

}
