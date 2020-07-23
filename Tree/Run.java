package Tree;
import java.util.*;

public class Run {

    public static void main(String[] args) {
        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(5);
        // TreeNode n4 = new TreeNode(3);        
        // TreeNode n5 = new TreeNode(4);
        // TreeNode n6 = new TreeNode(6);

        // n1.left = n2;
        // n1.right = n3;

        // n2.left = n4;
        // n2.right = n5;

        // n3.right = n6;
        // Serialization s1 = new Serialization();
        // // s1.preOrderR(n1);
        // TreeNode res = s1.serialize(n1);
        // while (res != null) {
        //     System.out.print(res.key);
        //     res = res.right;
        // }

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);


        n1.left = n2;

        n2.left = n3;
        
        ToDoublyList t1 = new ToDoublyList();
        t1.toDoubleLinkedList(n1);
      


        
    }

}