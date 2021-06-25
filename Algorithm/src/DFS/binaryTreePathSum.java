package DFS;

import java.util.ArrayList;
import java.util.List;

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
    if(root.val == sum && root.left == null && root.right == null) return true;
    return findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);
  }
// ----------------------------------------
  public static List<List<Integer>> findAllPath(TreeNode root, int sum){
    List<List<Integer> result = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    findAllPathHelp(root, sum, result, subres);
    return result;
  }

  public static void findAllPathHelp(TreeNode root, int sum, List<List<Integer>> result; List<Integer> subres){
    if(root == null) return;
    subres.add(root.val);
    if(root.val == sum && root.left == null && root.right == null){
      result.add(new ArrayList<>(subres));
    }else{
      findAllPathHelp(root.left, sum - root.val, result, subres);
      findAllPathHelp(root.right, sum - root.val, result, subres);
    }
    subres.remove(subres.size() - 1);
  }
// ----------------------------------------

  public static int findSum(TreeNode root){
    int sum = 0;
    int cur = 0;

    findSumHelp(root, cur, sum);
    return sum;
  }

  public static void findSumHelp(TreeNode root, int cur, int sum){
    if(root == null) return;
    cur = cur * 10 + root.val;
    if(root.left == null && root.right == null){
      sum += cur;
    }else{
      findSumHelp(root.left, cur, sum);
      findSumHelp(root.right, cur, sum);
    }
    cur = cur / 10;
  }

// ----------------------------------------
  public static boolean findOnePath(TreeNode root, int[] sequence) {
    if(root == null){
      return sequence.length == 0;
    }
    return findOnePathHelp(root, sequence, 0);
  }

  public static boolean findOnePathHelp(TreeNode root, int[] sequence, int sequenceIndex){
    if(root == null) return false;
    if(sequenceIndex >= sequence.length || sequence[sequenceIndex] != root.val) return false;
    if(root.left == null && root.right == null && sequence.length - 1 == sequenceIndex) return true;
    return findOnePathHelp(root.left, sequence, sequenceIndex + 1) || findOnePathHelp(root.right, sequence, sequenceIndex + 1);
  }

  // ----------------------------------------

  public static int diameter = 0;
  public static int maxDiameter(TreeNode root){
    diameterHelp(root);
    return diameter;
  }
  public static int diameterHelp(TreeNode root){
    if(root == null) return 0;
    int leftheight = diameterHelp(root.left);
    int rightheight = diameterHelp(root.right);
    int curdiameter = leftheight + rightheight + 1;
    diameter = Math.max(curdiameter, diameter);
    return Math.max(leftheight, rightheight) + 1;
  }

  // ----------------------------------------
  public static int sum = 0;
  public static int findNodesSum(TreeNode root){
    findNodesSumHelP(root);
    return sum;
  }
  public static int findNodesSumHelP(TreeNode root){
    if(root == null) return 0;
    int leftsum = findNodesSumHelP(root.left);
    int rightsum = findNodesSumHelP(root.right);
    int cursum = leftsum + rightsum + root.val;
    sum = Math.max(sum, cursum);
    return Math.max(leftsum, rightsum) + root.val;
  }
}
