package Tree;
import java.util.*;
class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v) {
        key = v;
    }
}
class reconstruct {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1);
    }
    private TreeNode construct(int[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        
        // find root
        TreeNode root = new TreeNode(preOrder[left]);
        // 
        int pivot = findPivot(preOrder, left, right);
        root.left = construct(preOrder, left + 1, pivot - 1);
        root.right = construct(preOrder, pivot, right);
        return root;
    }
    private int findPivot(int[] preOrder, int left, int right) {
        int pivot = left;
        while (preOrder[left] >= preOrder[pivot]) {
            pivot++;
        }
        return pivot;
    }
    
}