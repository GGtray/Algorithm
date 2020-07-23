package Queue;


// stack

public class MyStack {
    private static class ListNode {
        public int value;
        private ListNode next;
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    // data field
    private ListNode head;
    private int size;

    // constructor
    public MyStack(ListNode head, int size) {
        head = null;
        size = 0;
    }

    // void push(int value)
    public void push(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
        size++;
    }

    // Integer pop()
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        ListNode prev = head;
        int res = head.value;
        head = head.next;
        prev.next = null;
        return res;
    }

}