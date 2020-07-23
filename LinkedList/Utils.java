package LinkedList;

public class Utils {
    public static ListNode ArrayToLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int ele : array) {
            cur.next = new ListNode(ele);
            cur = cur.next;
        }
        return dummy.next;
    }
}