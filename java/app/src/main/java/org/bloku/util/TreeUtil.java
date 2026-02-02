package org.bloku.util;

import java.util.List;
import org.bloku.domain.TreeNode;

public class TreeUtil {
  private TreeUtil() {}

  public static TreeNode buildTreeNode(List<Integer> nodeValues) {
    List<TreeNode> nodes = nodeValues.stream().map(TreeNode::new).toList();
    for (int i = 0; i < nodes.size(); i++) {
      TreeNode node = getNullableNode(nodes, i);
      if (node == null) continue;
      if (i + i + 1 < nodes.size()) {
        node.left = getNullableNode(nodes, i + i + 1);
      }
      if (i + i + 2 < nodes.size()) {
        node.right = getNullableNode(nodes, i + i + 2);
      }
    }
    return nodes.isEmpty() ? null : nodes.getFirst();
  }

  private static TreeNode getNullableNode(List<TreeNode> nodes, int pos) {
    return nodes.get(pos).val == -1 ? null : nodes.get(pos);
  }
}
