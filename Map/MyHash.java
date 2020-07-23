package Map;

// import java.util.Arrays;
// public class MyHash<K, V> {
//     // Node is a static class of MyHashMap, since it is:
//     // very closely bounded to MyHashMap class
//     // need to access this class outside from MyHash class
//     public static class Node<K, V> {
//         final K key;
//         V value;
//         Node<K, V> next;
//         Node(K key, V value) {
//             this.key = key;
//             this.value = value;
//         }

//         public K getKey() {
//             return key;
//         }

//         public V getValue() {
//             return value;
//         }

//         public void setValue(V value) {
//             this.value = value;
//         }
//     }
//     // static final variable are global constants 
//     public static final int DEFAULT_CAPACITY = 16;
//     public static final float DEFAULT_LOAD_FACTOR = 0.75f;

//     private Node<K, V>[] array;
//     private int size; // how many key-value pairs 
//     private float loadFactor;

//     public MyHash(){
//         this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
//     }

//     public MyHash(int cap, float loadFactor) {
//         if (cap <= 0) {
//             throw new IllegalArgumentException("cap can not be <= 0");
//         }
//         // @SuppressWarnings
//         this.array = (Node<K, V>[]) (new Node[cap]);
//         this.size = 0;
//         this.loadFactor = loadFactor;
//     }

//     public int size(){
//         return size;
//     }

//     public boolean isEmpty() {
//         return size == 0;
//     }

//     public void clear() {
//         Arrays.fill(this.array, null);
//         size = 0;
//     }

//     private int hash(K key) {
//         if (key == null) {
//             return 0;
//         }
//         return key.hashCode() & 0X7FFFFFFF;
//     }

//     private int getIndex(K key) {
//         return hash(key) % array.length;
//     }

//     private boolean equalsValue(V v1, V v2) {
//         if (v1 == null && v2 == null) {
//             return true;
//         }

//         if (v1 == null || v2 == null) {
//             return false;
//         }
//         return v1.equals(v2);
//     }
//     private boolean equalsKey(K k1, K k2) {
//         if (k1 == null && k2 == null) {
//             return true;
//         }

//         if (k1 == null || k2 == null) {
//             return false;
//         }
//         return k1.equals(k2);
//     }

//     public boolean containsKey(K key) {
//         int index = getIndex(key);
//         Node<K, V> node = array[index];
//         while (node != null) {
//             if (equalsKey(node.key, key)) {
//                 return true;
//             }
//             node = node.next;
//         }
//         return false;
//     }

//     public V get(K key) {
//         int inde = getIndex(key);
//         Node<K, V> node = array[index];
//         while (node != null) {
//             if (equalsKey(node.key), key)) {
//                 return node.value;
//             }
//             node = node.next;
//         }
//         return null;
//     }

//     public V put(K key, V value) {
//         int index = getIndex(key);
//         Node<K, V> head = array[index];
//         Node<K, V> node = head;
//         while (node != null) {
//             if (equalsKey(node.key, key)) {
//                 V result = node.value;
//                 node.value = value;
//                 return result;
//             }
//             node = node.next;
//         } 
//         Node<K, V> newNode = new Node(key, value);
//         newNode.next = head;
//         array[index] = newNode;
//         size++;
//         if (needReashing()) {
//             rehashing();
//         }
//         return null;
//     }

//     private boolean needReashing() {
//         float ratio = (size + 0.0f) / array.length;
//         return ratio >= loadFactor;
//     }

//     private void rehashing() {
//         // new double sized array
//         // for each node in the old array, 
//         // do the put() operation to the new larger array
//     }

//     public V remove(K key) {
//         // get index
//         // delete operation on the linked list
//         // size--
//     }

// }
