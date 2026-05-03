package org.bloku.task._1722;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimize Hamming Distance After Swap Operations")
@Topics({ARRAY, UNION_FIND})
class Solution {

  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    int n = source.length;
    UnionFind uf = new UnionFind(n);
    for (int[] pair : allowedSwaps) {
      uf.union(pair[0], pair[1]);
    }
    Map<Integer, List<Integer>> groups = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int group = uf.find(i);
      groups.computeIfAbsent(group, __ -> new ArrayList<>()).add(i);
    }
    int result = 0;
    for (List<Integer> group : groups.values()) {
      Map<Integer, Integer> frequency = new HashMap<>();
      for (int idx : group) {
        frequency.merge(source[idx], 1, Integer::sum);
        frequency.merge(target[idx], -1, Integer::sum);
      }
      for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
        if (entry.getValue() > 0) result += entry.getValue();
      }
    }
    return result;
  }

  private static final class UnionFind {
    private final int[] parent;

    UnionFind(int n) {
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int i) {
      if (parent[i] == i) return i;
      return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
      int pi = find(i);
      int pj = find(j);
      parent[pi] = parent[pj];
    }
  }
}
