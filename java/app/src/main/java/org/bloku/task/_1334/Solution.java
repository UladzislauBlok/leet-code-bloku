package org.bloku.task._1334;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the City With the Smallest Number of Neighbors at a Threshold Distance")
@Topics({DYNAMIC_PROGRAMMING, GRAPH, DIJKSTRA})
class Solution {

  public int findTheCity_Dijkstra(int n, int[][] edges, int distanceThreshold) {
    int[] res = new int[] {-1, Integer.MAX_VALUE};
    List<int[]>[] adjacencyList = new List[n];
    for (int[] edge : edges) {
      if (adjacencyList[edge[0]] == null) adjacencyList[edge[0]] = new ArrayList<>();
      adjacencyList[edge[0]].add(new int[] {edge[1], edge[2]});
      if (adjacencyList[edge[1]] == null) adjacencyList[edge[1]] = new ArrayList<>();
      adjacencyList[edge[1]].add(new int[] {edge[0], edge[2]});
    }
    for (int i = 0; i < n; i++) {
      int count = 0;
      int[] cost = new int[n];
      Arrays.fill(cost, Integer.MAX_VALUE);
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
      cost[i] = 0;
      pq.add(new int[] {i, 0});
      while (!pq.isEmpty()) {
        int[] v = pq.poll();
        if (cost[v[0]] < v[1]) continue;
        if (v[1] > distanceThreshold) break;
        count++;
        List<int[]> neighbors = adjacencyList[v[0]] == null ? List.of() : adjacencyList[v[0]];
        for (int[] neighbor : neighbors) {
          int nextCost = neighbor[1] + v[1];
          if (cost[neighbor[0]] > nextCost) {
            cost[neighbor[0]] = nextCost;
            pq.add(new int[] {neighbor[0], nextCost});
          }
        }
      }
      if (res[1] >= count) {
        res[0] = i;
        res[1] = count;
      }
    }
    return res[0];
  }

  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], 1000001);
      dist[i][i] = 0;
    }
    for (int[] edge : edges) {
      dist[edge[0]][edge[1]] = edge[2];
      dist[edge[1]][edge[0]] = edge[2];
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
    int minReachable = n;
    int resultCity = -1;
    for (int i = 0; i < n; i++) {
      int reachableCount = 0;
      for (int j = 0; j < n; j++) {
        if (i != j && dist[i][j] <= distanceThreshold) {
          reachableCount++;
        }
      }
      if (reachableCount <= minReachable) {
        minReachable = reachableCount;
        resultCity = i;
      }
    }
    return resultCity;
  }
  /*
      it's Dijkstra
      number of cities is small is we can just check every posibility (start from every city)
      same idea as in 2976. it's can be done with Dijkstra, but DP Floyd-Warshall Algorithm is better here
  */
}
