package org.bloku.task._2096;

import static org.bloku.util.Topic.*;

import org.bloku.domain.TreeNode;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Step-By-Step Directions From a Binary Tree Node to Another")
@Topics({STRING, TREE, DFS})
class Solution {

  public String getDirections(TreeNode root, int startValue, int destValue) {
    if (root == null) {
      throw new IllegalArgumentException("Root cannot be null.");
    }
    StringBuilder startPath = new StringBuilder();
    StringBuilder destPath = new StringBuilder();
    if (!findPath(root, startValue, startPath) || !findPath(root, destValue, destPath)) {
      throw new IllegalArgumentException("Target nodes must exist within the tree.");
    }
    int skipNodes = 0;
    int maxCommonLength = Math.min(startPath.length(), destPath.length());
    while (skipNodes < maxCommonLength
        && startPath.charAt(skipNodes) == destPath.charAt(skipNodes)) {
      skipNodes++;
    }
    StringBuilder pathResult = new StringBuilder();
    int upMovesCount = startPath.length() - skipNodes;
    for (int i = 0; i < upMovesCount; i++) {
      pathResult.append('U');
    }
    pathResult.append(destPath.substring(skipNodes));
    return pathResult.toString();
  }

  private static boolean findPath(TreeNode currentNode, int target, StringBuilder pathAccumulator) {
    if (currentNode == null) {
      return false;
    }
    if (currentNode.val == target) {
      return true;
    }
    pathAccumulator.append('L');
    if (findPath(currentNode.left, target, pathAccumulator)) {
      return true;
    }
    pathAccumulator.setLength(pathAccumulator.length() - 1);
    pathAccumulator.append('R');
    if (findPath(currentNode.right, target, pathAccumulator)) {
      return true;
    }
    pathAccumulator.setLength(pathAccumulator.length() - 1);
    return false;
  }
}
