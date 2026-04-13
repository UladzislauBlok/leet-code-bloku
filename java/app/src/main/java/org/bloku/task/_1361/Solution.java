package org.bloku.task._1361;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Validate Binary Tree Nodes")
@Topics({TREE, DFS, BINARY_TREE})
class Solution {

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    boolean[] visited = new boolean[n];
    for (int node : leftChild) {
      if (node == -1) continue;
      if (visited[node]) return false;
      visited[node] = true;
    }
    for (int node : rightChild) {
      if (node == -1) continue;
      if (visited[node]) return false;
      visited[node] = true;
    }
    int root = -1;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (root != -1) return false;
        root = i;
      }
    }
    if (root == -1) return false;
    Arrays.fill(visited, false);
    dfs(root, leftChild, rightChild, visited);
    for (boolean node : visited) if (!node) return false;
    return true;
  }

  private void dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
    if (visited[root]) return;
    visited[root] = true;
    if (leftChild[root] != -1) dfs(leftChild[root], leftChild, rightChild, visited);
    if (rightChild[root] != -1) dfs(rightChild[root], leftChild, rightChild, visited);
  }
}
