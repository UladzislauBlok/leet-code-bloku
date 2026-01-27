package org.bloku.task._3650;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@LeetCodeName("Minimum Cost Path with Edge Reversals")
@Topics({GRAPH, HEAP_PRIORITY_QUEUE, DIJKSTRA, SHORTEST_PATH})
class Solution {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] adjacencyList = new List[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(new int[] {edge[1], edge[2]});
            adjacencyList[edge[1]].add(new int[] {edge[0], edge[2] * 2});
        }
        pq.add(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int label = node[0];
            int weight = node[1];
            if (label == n - 1) return weight;
            distance[label] = weight;
            for (int[] path : adjacencyList[label])
                if (weight + path[1] < distance[path[0]]) {
                    distance[path[0]] = weight + path[1];
                    pq.add(new int[] {path[0], weight + path[1]});
                }
        }
        return -1;
    }
}
