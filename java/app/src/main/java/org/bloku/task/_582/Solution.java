package org.bloku.task._582;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Kill Process")
@Topics({HASH_TABLE, TREE, DFS})
class Solution {

  private final List<Integer> result = new ArrayList<>();
  private final Map<Integer, List<Integer>> tree = new HashMap<>();

  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    int n = pid.size();
    int root = -1;
    for (int i = 0; i < n; i++) {
      int id = pid.get(i);
      int parId = ppid.get(i);
      if (parId == 0) {
        root = id;
      } else {
        tree.computeIfAbsent(parId, __ -> new ArrayList<>()).add(id);
      }
    }
    dfs(root, root == kill, kill);
    return result;
  }

  private void dfs(int node, boolean isKilled, int kill) {
    if (isKilled) result.add(node);
    for (int child : tree.getOrDefault(node, List.of())) {
      dfs(child, isKilled || child == kill, kill);
    }
  }
}
