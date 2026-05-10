import Hash.HashFunc;
import Hash.HashMapp;
import Hash.LRUCache;
import Hash.LinkedHashMapDemo;
import List.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello my World");

        Main m = new Main();
            //m.listDemos();
        m.mapDemos();
        //m.main();


    }

    public void listDemos(){
        A_ArrayList_Basics aArrayListBasics = new A_ArrayList_Basics();
        aArrayListBasics.createArrayList();

        B_Comparator bComp = new B_Comparator();
        bComp.compp();

        C_LinkedList cll = new C_LinkedList();
        cll.linkk();

        D_Vector dv = new D_Vector();
        dv.vectorDemo();
//
        E_Stack es = new E_Stack();
        es.stackDemo();

        F_CopyOnWriteArrayList fc= new F_CopyOnWriteArrayList();
        fc.copyOnWriteDemo_SingleThread();
        fc.copyOnWrite_MultiThread();

    }

    public void mapDemos(){

        HashMapp h1 = new HashMapp();
        //h1.hashmapDemo();
        //h1.marks();

        HashFunc hf = new HashFunc();
        //System.out.println("Hash O/p: " + hf.simpleHash("45"));
        //hf.moreLoadFactorTry();

        LinkedHashMapDemo lmp = new LinkedHashMapDemo();
        //lmp.linkedMap();

        LRUCache<String,Integer> l1 = new LRUCache<>(3);
        //l1.lruCacheDemo();

    }

    public void main(){
        System.out.println("Main method without public static can be used as normal method" );
    }

}