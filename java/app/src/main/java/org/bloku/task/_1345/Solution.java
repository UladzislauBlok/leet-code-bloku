package org.bloku.task._1345;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Jump Game IV")
@Topics({HASH_TABLE, ARRAY, BFS})
class Solution {

  public int minJumps(int[] nums) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      graph.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
    }
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    queue.offer(0);
    visited[0] = true;
    int steps = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      steps++;
      for (int i = 0; i < size; i++) {
        int pos = queue.poll();
        if (pos == n - 1) {
          return steps;
        }
        if (pos > 0 && !visited[pos - 1]) {
          queue.offer(pos - 1);
          visited[pos - 1] = true;
        }
        if (!visited[pos + 1]) {
          queue.offer(pos + 1);
          visited[pos + 1] = true;
        }
        for (int nextPos : graph.get(nums[pos])) {
          if (pos == nextPos || visited[nextPos]) {
            continue;
          }
          queue.offer(nextPos);
          visited[nextPos] = true;
        }
        graph.get(nums[pos]).clear();
      }
    }
    return -1;
  }
}
