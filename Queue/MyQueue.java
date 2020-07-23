package Queue;
import java.util.ArrayDeque;
public class MyQueue {
    private static class ListNodeD {
        private int value;
        private ListNodeD next;
        private ListNodeD prev;
        public ListNodeD(int value) {
            this.value = value;
        } 
    }
    private ListNodeD head;
    private ListNodeD tail;
    // constructor
    public MyQueue() {
        head = null;
        tail = null;
    }
    // void offer(int value)
    public void offer(int value) {
        if (head == null) {
            ListNodeD newNode = new ListNodeD(value);
            head = newNode;
            tail = newNode;
            return;
        }
        // add at first
        ListNodeD newHead = new ListNodeD(value);
        newHead.next = head;
        head = newHead;
        head.prev = null;
    }
    // Integer poll()
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int res = tail.value;
        tail.prev.next = null;
        tail = tail.prev;
        return res; 
    }
}