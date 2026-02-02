package org.bloku.task._1339;

import static org.bloku.util.Topic.*;

import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Product of Splitted Binary Tree")
@Topics({TREE, BINARY_TREE, DFS})
class Solution {

  private static final int MOD = (int) 1e9 + 7;

  public int maxProduct(TreeNode root) {
    int sum = sum(root);
    return (int) (split(root, sum) % MOD);
  }

  private int sum(TreeNode root) {
    if (root == null) return 0;
    int left = sum(root.left);
    int right = sum(root.right);
    int res = left + right + root.val;
    root.val = res;
    return res;
  }

  private long split(TreeNode root, int sum) {
    if (root == null) return -1;
    long best = split(root.left, sum);
    best = Math.max(best, split(root.right, sum));
    best = Math.max(best, (1L * sum - root.val) * root.val);
    return best;
  }
}
