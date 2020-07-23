package LinkedList;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(1);

        n1.next = n2; n2.next = n3;

        InsertionSort s1 = new InsertionSort();
        s1.insertionSort(n1);

    }
}