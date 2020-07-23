package LinkedList;

import java.util.Random;

import javax.xml.crypto.NodeSetData;

public class QuickSort {
    private ListNode generatePivot(ListNode head) {
        ListNode cur = head;
        int count = 1;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        int size = count - 1;
        Random random = new Random();
        int pivotIdx = 1 + random.nextInt(size);
        count = 1;
        cur = head;
        while (count < pivotIdx) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    private ListNode[] partition(ListNode head) {
      // [0]: the head of left
      // [1]: the head of right
      // partition one linked list into 2 pieces, left tail is null
      ListNode[] res = new ListNode[3];
      ListNode pivot = generatePivot(head);
      ListNode sd = new ListNode(0);
      ListNode ld = new ListNode(0);
      ListNode md = new ListNode(0);
      
      ListNode cur = head;
      ListNode scur = sd, lcur = ld, mcur = md;
      while (cur != null) {
        if (cur.value < pivot.value) {
          scur.next = cur;
          scur = scur.next;
        } else if (cur.value > pivot.value) {
          lcur.next = cur;
          lcur = lcur.next;
        } else {
          mcur.next = cur;
          mcur = mcur.next;
        }
        cur = cur.next;
      }
      scur.next = null;
      lcur.next = null;
      mcur.next = null;
      res[0] = sd.next;
      res[1] = ld.next;
      res[2] = md.next;
      return res;
    }
    private ListNode preOrder(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode[] nodes = partition(head);
      ListNode left = preOrder(nodes[0]);
      ListNode right = preOrder(nodes[1]);
      if (left == null) {
          nodes[2].next = right;
          ListNode cur = nodes[2];
          while (cur.next != null) {
              cur = cur.next;
          }
          cur.next = right;
          return nodes[2];
      } else {
        ListNode cur = left;
        while (cur.next != null) {
          cur = cur.next;
        }
        cur.next = nodes[2];
        nodes[2].next = right;
        return left;
      }
    }
    public ListNode quickSort(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode newHead = preOrder(head);
      return newHead;
    }
  }