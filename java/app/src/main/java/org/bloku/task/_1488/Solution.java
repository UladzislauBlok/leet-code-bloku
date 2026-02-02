package org.bloku.task._1488;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Avoid Flood in The City")
@Topics({HASH_TABLE, ARRAY, RBT, UNION_FIND, GREEDY})
class Solution {

  public int[] avoidFlood(int[] rain) {
    int n = rain.length;
    UnionFind uf = new UnionFind(n + 1);
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[n];
    Arrays.fill(res, 1);
    for (int i = 0; i < n; i++) {
      int lake = rain[i];
      if (lake == 0) continue;
      res[i] = -1;
      uf.unite(i);
      if (map.containsKey(lake)) {
        int prev = map.get(lake);
        int dry = uf.find(prev + 1);
        if (dry >= i) return new int[0];
        res[dry] = lake;
        uf.unite(dry);
        map.put(lake, i);
      } else {
        map.put(lake, i);
      }
    }

    return res;
  }

  public int[] avoidFloodRBT(int[] rains) {
    int n = rains.length;
    int[] res = new int[n];
    Map<Integer, Integer> lakeToDay = new HashMap<>();
    TreeSet<Integer> dry = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      int lake = rains[i];
      if (lake > 0) {
        if (lakeToDay.containsKey(lake)) {
          int handler = lakeToDay.get(lake);
          Integer find = dry.higher(handler);
          if (find == null) return new int[] {};
          dry.remove(find);
          res[find] = lake;
        }
        lakeToDay.put(lake, i);
        res[i] = -1;
      } else {
        dry.add(i);
        res[i] = 1;
      }
    }
    return res;
  }

  private static class UnionFind {
    int[] parent;

    public UnionFind(int size) {
      parent = new int[size + 1];
      for (int i = 0; i <= size; i++) {
        parent[i] = i;
      }
    }

    public int find(int i) {
      if (parent[i] == i) return i;
      parent[i] = find(parent[i]);
      return parent[i];
    }

    public void unite(int i) {
      parent[i] = find(i + 1);
    }
  }
}
