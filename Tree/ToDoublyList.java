package Tree;

public class ToDoublyList {
    TreeNode first = null;
    TreeNode prev = null;
  private void inorder(TreeNode cur) {
    if (cur == null) {
      return;
    }

    inorder(cur.left); 
    //  
    if (prev != null) {
      prev.right = cur;
      cur.left = prev;
    } else {
      first = cur;
    }
    prev = cur;

    inorder(cur.right);


  }
  public TreeNode toDoubleLinkedList(TreeNode root) {
    // inorder traversal sequence
    // data structure:
    // first: head of the list

    inorder(root);
    return first;
  }
}