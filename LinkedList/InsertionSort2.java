package LinkedList;

public class InsertionSort2 {
    public ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // define (dummy, cur) sorted
        // init cur = head, term cur = empty
        // for each loop, insert cur into list (dummy, prev] cur = next
        ListNode dummy = new ListNode(0), cur = head, prev = dummy;
        while (cur != null) {
            ListNode next = cur;
            cur.next = null;
            prev.next = null;

            head = insert(head, prev, cur);

            cur = next;
        }
        return dummy.next;
    }
    private ListNode insert(ListNode head, ListNode tail, ListNode target) {
        // return the newHead, update prev pointer, insert the target
        // define (dummy, cur) is checked for sorted property
        // init cur = head, term: cur.value > target || cur == null, post: update tail as the end of list
        // post: insert the target node
        // define [head, prev] the return list
        // prev.next = target, prev = target, prev.next = cur
        ListNode cur = head, dummy = new ListNode(0), prev = dummy;
        while (cur != null && cur.value <= target.value) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = target;
        prev = target;
        prev.next = cur;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
