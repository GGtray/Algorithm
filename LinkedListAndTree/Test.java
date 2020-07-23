package LinkedListAndTree;
import java.util.*;

class ListNode  {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2  = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // stackPreIterate(n1);
        stackPostIterate(n1);
        // normalIterate(n1);
        // preOrder(n1);
        // postOrder(n1);
    }
    /**stack simulate post order */
    private static void stackPostIterate(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.push(head);
        ListNode prev = null;
        while(!stack.isEmpty()) {
            ListNode cur = stack.peek();
            if (prev == null || cur.next != null && prev.next == cur) {
                stack.push(cur.next);
            } else if (cur.next == null || cur.next == prev) {
                System.out.println(stack.pop().value);
            }
            prev = cur;
        }
    }
    /** stack simulate preorder */
    private static ListNode stackPreIterate(ListNode head) {
        // iterate linked list using stack
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            System.out.println(cur.value);
            if (cur.next != null) {
                stack.push(cur.next);
            }
        }
        return head;
    }
    /**post order traversal */
    private static void postOrder(ListNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.next);
        System.out.println(head.value);
    }


    /** preOrder traversal */
    private static void preOrder(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preOrder(head.next);
    }
    /**normal */
    private static ListNode normalIterate(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
        return head;
    }
}