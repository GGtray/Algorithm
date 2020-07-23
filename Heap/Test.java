package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2);
        pq.offer(5);
        pq.offer(2);
        pq.offer(2);
        pq.offer(2);
        
        // System.out.print(pq.size());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        pq.offer(5);
        System.out.println(pq.poll());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1 == i2) {
                    return 0;
                } 
                return i1 < i2 ? i1 : i2;
            }
        });

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(11, (Integer i1, Integer i2) -> {
            if (i1 == i2) {
                return 0;
            }
            return i1 < i2 ? i1 : i2;
        });
    }
}

class MinHeap {
	private int[] array;
	private int size;
	
	public MinHeap(int[] array) {
        size = array.length;
        heapify(array);
	}
	private void percolateUp(int position) {
        // compare current with parent, if less than, swap up
        // untill heap sort property is 
        int current = position;
        while (position > 0) {
            int parentIndex = (current - 1) / 2;
            if (array[parentIndex] > array[current]) {
                swap(array, parentIndex, current); 
            } else {
                break;
            }
            current = parentIndex;
        }
        // int current = position;
        // while (current > 0 && array[current] < array[(current - 1) / 2]) {
        //     swap(array, current, (current - 1) / 2);
        //     current = (current - 1) / 2;
        // }
        
    }
	private void percolateDown(int position) {
        // for each loop, compare the current's two children, if anyone 
        // is less than current, swap current with the smaller one.
        // do while the heap order is satisfied
        int current = position;
        while (current <= size / 2 - 1){
            int leftChldIndex = current * 2 + 1;
            int rightChildIndex = current * 2 + 2;
            int swapCandidate = leftChldIndex;
            if (rightChildIndex <= size - 1 && array[leftChldIndex]>= array[rightChildIndex]) {
                swapCandidate = rightChildIndex;
            }

            if (array[current] > array[swapCandidate]) {
                swap(array, current, swapCandidate);
            } else {
                break;
            }
            current = swapCandidate; 
 
        }

        // problem here is that right child may not exists. even left child is not always exists
        // int current = position;
        // while (array[current] < array[current * 2 + 1] || array[current] < array[current * 2 + 2]) {
        //     int next = array[current * 2 + 1] < array[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
        //     swap(array, next, current);
        //     current = next;
        // }
    }
    
    
    public void offer(int element) {
        if (size == array.length) {
            // resize 
            // int[] newArray = new int[array.length * 2];
            // // copy(array, newArray);
            // array = newArray;

            // or throw Exception
            
        }
        array[size] = element;
        percolateUp(size);
        size++;
    } 
    
    
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        int res = array[0];
        size--;
        array[0] = array[size - 1];
        percolateDown(0);
        return res;
    }
    
    
    public int peek(){
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public void heapify(int[] array) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
	


	public boolean isEmpty() {
		return size == 0;
    }
    
	public int size() {
		return size;
    }
    
    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
	
}

class MinHeap1<E>  { // implements problem
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private Object[] queue;
    /**
     * The number of elements in the priority queue.
     */
    private int size = 0;
    /**
     * The comparator, or null if priority queue uses elements'
     * natural ordering.
     */
    private final Comparator<? super E> comparator;
    public MinHeap1() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }
    public MinHeap1(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
    /**
     * Establishes the heap invariant (described above) in the entire tree,
     * assuming nothing about the order of the elements prior to the call.
     */
    @SuppressWarnings("unchecked")

    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            siftDown(i, (E) queue[i]);
    }
    /**
     * Returns the comparator used to order the elements in this
     * queue, or {@code null} if this queue is sorted according to
     * the {@linkplain Comparable natural ordering} of its elements.
     *
     * @return the comparator used to order this queue, or
     *         {@code null} if this queue is sorted according to the
     *         natural ordering of its elements
     */
    public Comparator<? super E> comparator() {
        return comparator;
    }
    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E e) {
        return offer(e);
    }
    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
       
        queue = Arrays.copyOf(queue, newCapacity);
    }

    
    

    
    
}