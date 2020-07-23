package Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Entry<K, V> {
    private final K key;
    private V value;
    Entry<K, V> next;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue(K key){
        return value;
    }
    public V setValue(V newValue){
        V oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }
    // final indicates that this method is not able to be overrided by sub class
    public final int hashCode(){
        return Objects.hashCode(key) ^ Objects.hashCode(key);
    }
    
    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
} 


public class Hash {
    static class Entry<String, Integer> {
        String key;
        Integer value;
        Entry<String, Integer> next;
        public Entry(String key, Integer value){
            this.key = key;
            this.value = value;
        }
        
        public boolean equals1(String key) {
            return false;
        }

    }
     /**------------------field------------------------------------ */
     private int size;
     private Entry<String, Integer>[] array;
 
     
     public Integer put(String newKey, Integer newValue) {
         int hash = newKey.hashCode();
         int index = hash % array.length;
         // iterate over bucket
         Entry<String, Integer> cur = array[index];
         while (cur != null) {
             if (cur.equals1(newKey)) {
                 Integer oldValue = cur.value;
                 cur.value = newValue;
                return oldValue;
             } 
             cur =  cur.next;
         }
         // means never been added 
         Entry<String, Integer> newEntry = new Entry<String, Integer>(newKey, newValue);
         newEntry.next = array[index];
         array[index] = newEntry;
         size++;
         return null;
     }

     public Integer get(String key, Integer value) {
         int hash = key.hashCode();
         int index = hash % array.length;
         // iterate over list in the bucket
         Entry<String, Integer> cur = array[index];
         while (cur != null) {
             if (cur.equals1(key)) {
                 return cur.value;
             } 
             cur = cur.next;
         }
         return null;
     }

     public int size() {
        return size;
     }

    public boolean isEmptry() {
        return size == 0;
    }
    /**
     * size()
     * isEmpty()
     * clear()
     * put(K key, V value)
     * get(K key)
     * containsKey(K key)
     * containsValue(V value)
     * remove(K key)
     */

    // Set<String> set = new HashSet<String>();
    // Map<String, Integer> map = new HashMap<>();
}

// Class Set1 {
//     /**
//      * add()
//      * clear()
//      * contains()
//      * isEmpty()
//      * iterator()
//      * remove()
//      * size()
//      */
// }