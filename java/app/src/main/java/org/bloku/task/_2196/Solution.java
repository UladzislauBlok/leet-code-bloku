package org.bloku.task._2196;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Create Binary Tree From Descriptions")
@Topics({HASH_TABLE, TREE})
class Solution {

  private static final int IS_LEFT_CHILD = 1;

  public TreeNode createBinaryTree(int[][] descriptions) {
    Map<Integer, TreeNode> nodeMapping = new HashMap<>();
    Set<Integer> childrenValues = new HashSet<>();

    for (int[] desc : descriptions) {
      int parentVal = desc[0];
      int childVal = desc[1];
      boolean isLeft = desc[2] == IS_LEFT_CHILD;

      TreeNode parent = nodeMapping.computeIfAbsent(parentVal, TreeNode::new);
      TreeNode child = nodeMapping.computeIfAbsent(childVal, TreeNode::new);

      childrenValues.add(childVal);

      if (isLeft) {
        parent.left = child;
      } else {
        parent.right = child;
      }
    }

    for (TreeNode node : nodeMapping.values()) {
      if (!childrenValues.contains(node.val)) {
        return node;
      }
    }

    return null;
  }
}
