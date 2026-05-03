package org.bloku.task._1059;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("All Paths from Source Lead to Destination")
@Topics({TOPOLOGICAL_SORT, DFS})
class Solution {

  private List<Integer>[] adjacentMap;
  private boolean[] good;
  private boolean[] visited;
  private int destination;

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    adjacentMap = new List[n];
    for (int[] edge : edges) {
      if (adjacentMap[edge[0]] == null) adjacentMap[edge[0]] = new ArrayList<>();
      adjacentMap[edge[0]].add(edge[1]);
    }
    this.good = new boolean[n];
    this.visited = new boolean[n];
    this.destination = destination;
    return dfs(source);
  }

  private boolean dfs(int idx) {
    if (adjacentMap[idx] == null) {
      return idx == destination;
    }
    if (good[idx]) return true;
    if (visited[idx]) return false; // cycle
    visited[idx] = true;
    for (int next : adjacentMap[idx]) {
      if (!dfs(next)) return false;
    }
    return good[idx] = true;
  }
}
