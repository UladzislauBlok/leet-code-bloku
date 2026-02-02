package org.bloku.task._1514;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Path with Maximum Probability")
@Topics({GRAPH, SHORTEST_PATH, DIJKSTRA})
class Solution {

  // inverted Dijkstra, and we need to peek path with the biggest weight
  public double maxProbabilityMap(
      int n, int[][] edges, double[] succProb, int startNode, int endNode) {
    Map<Integer, Node> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      Node node0 = map.get(edges[i][0]);
      Node node1 = map.get(edges[i][1]);
      if (node0 == null) {
        node0 = new Node(new HashMap<>());
        map.put(edges[i][0], node0);
      }
      if (node1 == null) {
        node1 = new Node(new HashMap<>());
        map.put(edges[i][1], node1);
      }
      node0.neighbors.put(edges[i][1], succProb[i]);
      node1.neighbors.put(edges[i][0], succProb[i]);
    }
    PriorityQueue<PqNode> pq =
        new PriorityQueue<>((a, b) -> (int) ((b.weight - a.weight) * 100000000));
    Set<Integer> visited = new HashSet<>();
    pq.add(new PqNode(startNode, 1));
    while (!pq.isEmpty()) {
      PqNode best = pq.poll();
      if (visited.contains(best.name)) continue;
      if (best.name == endNode) return best.weight;
      Node node = map.getOrDefault(best.name, new Node(Map.of()));
      for (Map.Entry<Integer, Double> neighbor : node.neighbors.entrySet()) {
        pq.add(new PqNode(neighbor.getKey(), best.weight * neighbor.getValue()));
      }
      visited.add(best.name);
    }
    return 0.0;
  }

  private record PqNode(int name, double weight) {}

  private record Node(Map<Integer, Double> neighbors) {}

  class Pair implements Comparable<Pair> {
    int node;
    double prob;

    Pair(int node, double prob) {
      this.node = node;
      this.prob = prob;
    }

    @Override
    public int compareTo(Pair other) {
      return Double.compare(other.prob, this.prob);
    }
  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    ArrayList<Pair>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      double w = succProb[i];
      graph[a].add(new Pair(b, w));
      graph[b].add(new Pair(a, w));
    }

    double[] best = new double[n];
    best[start] = 1.0;

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(start, 1.0));

    while (!pq.isEmpty()) {
      Pair cur = pq.poll();
      int node = cur.node;
      double prob = cur.prob;

      if (node == end) return prob;

      for (Pair nbr : graph[node]) {
        double newProb = prob * nbr.prob;
        if (newProb > best[nbr.node]) {
          best[nbr.node] = newProb;
          pq.add(new Pair(nbr.node, newProb));
        }
      }
    }

    return 0.0;
  }
}
