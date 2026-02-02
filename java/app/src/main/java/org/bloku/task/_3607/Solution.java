package org.bloku.task._3607;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Power Grid Maintenance")
@Topics({HASH_TABLE, UNION_FIND})
class Solution {

  // preprocess connections to find all groups
  // create n sorted sets and add stations; n = nums of groups
  // Revove from set when goes offline
  public int[] processQueries(int c, int[][] connections, int[][] queries) {
    UF uf = new UF(c + 1);
    for (int[] connection : connections) uf.union(connection[0], connection[1]);
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 1; i <= c; i++) {
      int group = uf.find(i);
      map.putIfAbsent(group, new LinkedHashSet<>());
      map.get(group).add(i);
    }
    List<Integer> res = new ArrayList<>();
    for (int[] query : queries) {
      int group = uf.find(query[1]);
      if (query[0] == 1) {
        if (!map.get(group).isEmpty()) {
          if (map.get(group).contains(query[1])) res.add(query[1]);
          else res.add(map.get(group).iterator().next());
        } else {
          res.add(-1);
        }
      } else {
        map.get(group).remove(query[1]);
      }
    }
    int[] answer = new int[res.size()];
    for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
    return answer;
  }

  private static class UF {
    private final int[] group;

    UF(int n) {
      this.group = new int[n];
      for (int i = 0; i < n; i++) group[i] = i;
    }

    int find(int i) {
      if (group[i] == i) return i;
      return group[i] = find(group[i]);
    }

    void union(int i, int j) {
      int gI = find(i);
      int gJ = find(j);
      group[gI] = gJ;
    }
  }
}
