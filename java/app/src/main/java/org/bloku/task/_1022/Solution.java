package org.bloku.task._1022;

import static org.bloku.util.Topic.*;

import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sum of Root To Leaf Binary Numbers")
@Topics({TREE, DFS, BINARY_TREE})
class Solution {

  public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode root, int sum) {
    if (root == null) return 0;
    sum <<= 1;
    sum += root.val;
    if (root.left == null && root.right == null) return sum;
    return dfs(root.left, sum) + dfs(root.right, sum);
  }
}
