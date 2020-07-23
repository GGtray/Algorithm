package Tree;

public class MaxTreePathI {
    int global;
  private int postOrder(TreeNode root) {
    if (root == null) {
      return 0; 
    }
    int left = postOrder(root.left);
    int right = postOrder(root.right);

    if (root.left != null && root.right != null) {
      global = Math.max(global, left + right + root.key);
      return Math.max(left, right) + root.key;
    }
    return root.left == null ? right + root.key : left + root.key;
  }
  public int maxPathSum(TreeNode root) {
    int global = Integer.MIN_VALUE;
    postOrder(root);
    return global;
  }
}