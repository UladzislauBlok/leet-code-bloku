package org.bloku.task._366;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Leaves of Binary Tree")
@Topics({DFS, BINARY_TREE})
class Solution {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    dfs(root, levels);
    return levels;
  }

  private int dfs(TreeNode node, List<List<Integer>> levels) {
    if (node == null) {
      return -1;
    }
    int leftDepth = dfs(node.left, levels);
    int rightDepth = dfs(node.right, levels);
    int currLevel = Math.max(leftDepth, rightDepth) + 1;
    if (levels.size() == currLevel) {
      levels.add(new ArrayList<>());
    }
    levels.get(currLevel).add(node.val);
    return currLevel;
  }
}
