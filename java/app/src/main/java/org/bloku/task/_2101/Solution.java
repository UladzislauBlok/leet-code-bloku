package org.bloku.task._2101;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Detonate the Maximum Bombs")
@Topics({MATH, DFS, BFS})
class Solution {

  private final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        double distance = distance(bombs[i], bombs[j]);
        if (distance <= bombs[i][2]) {
          adjacentMap.computeIfAbsent(i, __ -> new ArrayList<>()).add(j);
        }
      }
    }
    int max = 1;
    for (int i = 0; i < n; i++) {
      boolean[] visited = new boolean[n];
      max = Math.max(max, dfs(i, visited));
    }
    return max;
  }

  private int dfs(int curr, boolean[] visited) {
    int sum = 1;
    visited[curr] = true;
    for (Integer next : adjacentMap.getOrDefault(curr, List.of())) {
      if (visited[next]) continue;
      sum += dfs(next, visited);
    }
    return sum;
  }

  private double distance(int[] a, int[] b) {
    long x = Math.abs(1L * a[0] - b[0]);
    long y = Math.abs(1L * a[1] - b[1]);
    return Math.sqrt(x * x + y * y);
  }

  /*
      I'd say it's grouping think, so UF would be natural here,
      but how effectively calculate other bombs in range
      may be RBT waiting square borders...
      1 <= bombs.length <= 100
      actually number of bombs is small, let brute force with UF
      UF won't work because of edge case, where we'll combine too many groups
      let's just brute force with dfs;
  */
}
