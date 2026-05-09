package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class F_CopyOnWriteArrayList {

   public void copyOnWriteDemo_SingleThread() {

       //THIS IS SINGLE THREADED ONLY
       String[] a1 = new String[]{"Milk","Flour","Salt","Apples","Banana","Pasta"};

       List<String> groceries = new ArrayList<>(List.of(a1));
       CopyOnWriteArrayList<String> arList = new CopyOnWriteArrayList<>(List.of(a1));
      //List<String> groceries = new CopyOnWriteArrayList<>(List.of(a1));   => can be allowed as list too

       System.out.println("Grocery List: " + groceries);
       System.out.println("Arr List: " + arList );

       //Trying to modify while reading  => will give ConcurrentModificationException
       for(String item: groceries)
       {
           if(item.contains("Banana")){
               groceries.getFirst();   //this is allowed
               //groceries.add("Oranges");    // will give exception => ConcurrentModificationExpression
               System.out.println("Adding oranges while reading bananas");
           }
       }
       System.out.println("Updated List: " + groceries);

       for(String item1 : arList){
           if(item1.contains("Banana")){
               arList.getFirst();   //this is allowed
               arList.add("Oranges");    // will not give exception => as its VCopyOnWrite list
               System.out.println("Adding oranges while reading bananas");
           }
       }


       System.out.println("Updated Grocery List: " + groceries);
       System.out.println("Updated Arr List: " + arList );   // you can see Oranges updated here

    }

   public void copyOnWrite_MultiThread(){

       String[] stationery = new String[]{"Book","Pen","Pencil","Eraser","Sharpener"};
       List<String> l1 = new CopyOnWriteArrayList<>(Arrays.asList(stationery));

       /*
       * In Java, any local variable, formal parameter,
       * or exception parameter used but not declared within
       *  a lambda expression must be final or effectively final.
       * Failure to meet this requirement results in a compile-time error.
       * */



//       List<String> l1 = new ArrayList<>(Arrays.asList(stationery));    //ConcurrentModificationException
       final int[] i = {0};    //int i = 0; => Variable used in Lambda Expression should bt final or effectively final.
       Thread readThread = new Thread(()-> {
           try{
               while(i[0] < 10){
                for(String items: l1)
                   {

                       System.out.println("Reading: " + items);
                       Thread.sleep(100);
                   }
                   i[0]++;
               }
           }catch(Exception e){e.printStackTrace();}

       });


       Thread writerThread = new Thread( ()-> {
           try{
               Thread.sleep(500);
               l1.add("Scale");
               System.out.println("Scale Added");

               Thread.sleep(500);
               l1.remove("Pen");
               System.out.println("Removed Pen from List");

           }catch (Exception e){
               e.printStackTrace();}
       });

       readThread.start();
       writerThread.start();
   }

}
