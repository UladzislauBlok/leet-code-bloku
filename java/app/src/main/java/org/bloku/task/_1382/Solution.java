package org.bloku.task._1382;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Balance a Binary Search Tree")
@Topics({DIVIDE_AND_CONQUER, TREE, BINARY_TREE, INORDER_TRAVERSAL})
class Solution {

  public TreeNode balanceBST(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<>();
    inorder(root, nodes);
    return build(0, nodes.size() - 1, nodes);
  }

  private void inorder(TreeNode root, List<TreeNode> nodes) {
    if (root == null) return;
    inorder(root.left, nodes);
    nodes.add(root);
    inorder(root.right, nodes);
  }

  private TreeNode build(int start, int end, List<TreeNode> nodes) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    TreeNode root = nodes.get(mid);
    root.left = build(start, mid - 1, nodes);
    root.right = build(mid + 1, end, nodes);
    return root;
  }
}
