package org.bloku.task._3558;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Ways to Assign Edge Weights I")
@Topics({TREE, MATH, DFS, BFS})
class Solution {

  private static final int MODULUS = 1_000_000_007;

  public int assignEdgeWeights(int[][] edges) {
    if (edges == null || edges.length == 0) {
      return 0;
    }
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    for (int[] edge : edges) {
      int u = edge[0] - 1;
      int v = edge[1] - 1;
      adjacencyList.computeIfAbsent(u, _ -> new ArrayList<>()).add(v);
      adjacencyList.computeIfAbsent(v, _ -> new ArrayList<>()).add(u);
    }
    boolean[] visited = new boolean[edges.length + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    visited[0] = true;
    queue.add(0);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      for (int i = 0; i < size; i++) {
        int currNode = queue.poll();
        for (int neighbor : adjacencyList.getOrDefault(currNode, List.of())) {
          if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.offer(neighbor);
          }
        }
      }
    }
    // depth - 1 = number of edges until leaf
    // edges - 1 = number of ways to end up with odd
    int power = depth - 2;
    return computePowerMod(2, power, MODULUS);
  }

  private static int computePowerMod(long base, int power, int modulus) {
    long result = 1;
    long currentBase = base % modulus;
    while (power > 0) {
      if ((power & 1) == 1) {
        result = (result * currentBase) % modulus;
      }
      currentBase = (currentBase * currentBase) % modulus;
      power >>= 1;
    }
    return (int) result;
  }
}
