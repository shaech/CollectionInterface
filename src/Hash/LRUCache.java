package Hash;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

//On extending LInkedHashMap, we can generate override methods
public class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.7f,true);    //here accessOrder false, changes results
        this.capacity = capacity;
    }
    public void lruCacheDemo() {

       // LinkedHashMap<String, Integer> l1 = new LinkedHashMap<>(capacity,0.75f,true);
        LRUCache<String, Integer> l1 = new LRUCache<>(capacity);

        l1.put("A",1);
        l1.put("B",2);
        l1.put("C",3);
        l1.put("D",4);
        l1.get("B");
        l1.putIfAbsent("A",2);
        l1.put("E",5);

        System.out.println("L1 is: " + l1);


        /*IMPORTANT
        If super(capacity, loadFactor, accessOrder) are not return accessOrder by default is false.
        if true is done, LRU will change

        L1 ; accessOrder = false => L1 is: {D=4, A=2, E=5}
        L1 ; accessOrder = true => L1 is: {B=2, A=2, E=5}

         */
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //return super.removeEldestEntry(eldest);
        return size() > capacity;
    }
}
