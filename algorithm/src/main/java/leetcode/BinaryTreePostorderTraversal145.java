package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {

  public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;

    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    s1.push(root);

    while (s1.size() != 0) {
      TreeNode n = s1.pop();

      if (n.left != null) {
        s1.push(n.left);
      }
      if (n.right != null) {
        s1.push(n.right);
      }
      s2.push(n);
    }

    while (s2.size() != 0) {
      result.add(s2.pop().val);
    }
    return result;
  }

}
