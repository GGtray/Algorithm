package LinkedList;

public class SelectionSort {
    public ListNode selectionSort(ListNode head) {
      // selection sort
      // [0, i) sorted, [i, array.length - 1]: unsorted
      // for each loop: sort
      // select the minimum in unsorted area, swap it at the end of the sorted area
      // corner case: head == null || head.next == null
      // how to select the minimum ? traversal the unsorted area, reacord min pointer 
      // how to swap it ? maintain a cur pointer, and a prev pointer for the min
      if (head == null || head.next == null) {
        return head;
      }
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode cur = dummy;
      while (cur.next != null) {
        ListNode[] minAndPrev = findMin(cur.next);
        ListNode min = minAndPrev[0];
        ListNode prev = minAndPrev[1];
  
        if (prev != null) { // edge case
          prev.next = min.next;
        }
  
        cur.next = min;
        cur = cur.next;
      }
    //   cur.next = null;
      return dummy.next;
    }
    private ListNode[] findMin(ListNode head) {
      ListNode[] res = new ListNode[2];
      int min = head.value;
      ListNode prev = null;
      while (head != null) {
        if (min > head.value) {
          min = head.value;
          res[0] = head;
        }
        res[1] = prev;
        prev = head;
        head = head.next;
      }
      return res;
    }
  }
  