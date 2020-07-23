package Tree;

public class Serialization {
    TreeNode next = null;
   public void preOrderR(TreeNode root) {
       if (root == null) {
           return;
       }
       preOrderR(root.right);
       root.right = next;
       root.left = null;
       next = root;
       preOrderR(root.left);
   } 
   public TreeNode serialize(TreeNode root) {
        preOrderR(root);
        return root;
   }
}