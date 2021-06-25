package DFS;

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val){
    this.val = val;
  }
}

public class binaryTreePathSum {
  public static boolean findPath(TreeNode root, int sum){
    if(root == null) return false;
    if(root.val == sum && root.left == null && root.right == null);
    return findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);
  }
}
