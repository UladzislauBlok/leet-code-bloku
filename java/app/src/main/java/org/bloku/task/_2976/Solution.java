package org.bloku.task._2976;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Cost to Convert String I")
@Topics({ARRAY, STRING, GRAPH, DIJKSTRA})
class Solution {

  public long minimumCost(
      String source, String target, char[] original, char[] changed, int[] cost) {
    int n = original.length;
    int[][] graph = new int[26][26];
    for (int i = 0; i < n; i++) {
      int from = original[i] - 'a';
      int to = changed[i] - 'a';
      if (graph[from][to] == 0) graph[from][to] = cost[i];
      graph[from][to] = Math.min(graph[from][to], cost[i]);
    }
    long[][] paths = new long[26][26];
    for (int i = 0; i < 26; i++) {
      paths[i] = dijkstra(i, graph);
    }
    long res = 0;
    n = source.length();
    for (int i = 0; i < n; i++) {
      int from = source.charAt(i) - 'a';
      int to = target.charAt(i) - 'a';
      if (from == to) continue;
      if (paths[from][to] == Long.MAX_VALUE) return -1;
      res += paths[from][to];
    }
    return res;
  }

  private long[] dijkstra(int from, int[][] graph) {
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
    long[] cost = new long[26]; // from to every other
    Arrays.fill(cost, Long.MAX_VALUE);
    cost[from] = 0;
    pq.add(new long[] {from, 0});
    while (!pq.isEmpty()) {
      long[] node = pq.poll();
      for (int i = 0; i < 26; i++) {
        if (graph[(int) node[0]][i] == 0) continue;
        long nCost = node[1] + graph[(int) node[0]][i];
        if (cost[i] > nCost) {
          cost[i] = nCost;
          pq.add(new long[] {i, nCost});
        }
      }
    }
    return cost;
  }
}
