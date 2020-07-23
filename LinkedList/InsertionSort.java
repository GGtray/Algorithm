package LinkedList;

public class InsertionSort {
    private ListNode insert(ListNode dummy, ListNode insertNode, ListNode tail) {
        // (dummy, tial]: sorted
        ListNode prev = dummy, cur = dummy.next;
        while (cur != tail) {
          
          if (cur.value > insertNode.value) { // edge case: cur == null
            prev.next = insertNode;
            insertNode.next = cur;
            return tail;
          }
          prev = cur;
          cur = cur.next;
        }
        tail.next = insertNode;
        insertNode.next = null;
        return insertNode;
      }
      public ListNode insertionSort(ListNode head) {
        // idea: for each node in [head null)
        // insert it into a sorted list
        // data structure:
        // (dummy, cur) sorted;
        // (dummy, prev] sorted:
        // [cur, next) unsorted
        
        // for each loop:
        // partition into 2 pieces list, (dummy, cur), (cur, null)
        // init: 
        if (head == null || head.next == null) {
          return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode cur = head, prev = dummy;
        while (cur != null) {
          ListNode next = cur.next;
          cur.next = null;
    
          ListNode tail = insert(dummy, cur, cur); 
          tail.next = next;
          cur = next;
        }
    
        return dummy.next;
      }
}