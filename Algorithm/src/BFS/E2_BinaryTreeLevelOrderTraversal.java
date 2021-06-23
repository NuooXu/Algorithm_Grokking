package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val){
    this.val = val;
  }
}

public class E2_BinaryTreeLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root){
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()){
      int levelsize = queue.size();
      List<Integer> curlevel = new ArrayList<>(levelsize);
      for(int i = 0; i < levelsize; i++){
        TreeNode cur = queue.poll();
        curlevel.add(cur.val);
        if(cur.left != null) queue.offer(cur.left);
        if(cur.right != null) queue.offer(cur.right);
      }
      result.add(curlevel);
    }
    
    return result;
  }
}
