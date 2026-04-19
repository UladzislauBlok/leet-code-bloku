package org.bloku.task._3488;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Closest Equal Element Queries")
@Topics({ARRAY, HASH_TABLE, BINARY_SEARCH})
class Solution {

  public List<Integer> solveQueries_(int[] nums, int[] queries) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int n = nums.length, k = queries.length;
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(nums[i], __ -> new ArrayList<>()).add(i);
    }
    List<Integer> result = new ArrayList<>();
    for (int query : queries) {
      List<Integer> indexes = map.get(nums[query]);
      if (indexes.size() == 1) {
        result.add(-1);
        continue;
      }
      int pos = binarySearch(query, indexes);
      int next =
          pos < indexes.size() - 1
              ? indexes.get(pos + 1) - indexes.get(pos)
              : n - indexes.get(pos) + indexes.get(0);
      int prev =
          pos > 0
              ? indexes.get(pos) - indexes.get(pos - 1)
              : indexes.get(pos) + n - indexes.get(indexes.size() - 1);
      result.add(Math.min(next, prev));
    }
    return result;
  }

  private int binarySearch(int target, List<Integer> source) {
    int left = 0, right = source.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (source.get(mid) <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left - 1;
  }

  public List<Integer> solveQueries(int[] nums, int[] queries) {
    int n = nums.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for (List<Integer> list : map.values()) {
      int m = list.size();
      if (m == 1) continue;
      for (int i = 0; i < m; i++) {
        int curr = list.get(i);
        int next = list.get((i + 1) % m);
        int prev = list.get((i - 1 + m) % m);
        int distNext = Math.min(Math.abs(curr - next), n - Math.abs(curr - next));
        int distPrev = Math.min(Math.abs(curr - prev), n - Math.abs(curr - prev));
        ans[curr] = Math.min(distNext, distPrev);
      }
    }
    List<Integer> res = new ArrayList<>(queries.length);
    for (int q : queries) {
      res.add(ans[q]);
    }
    return res;
  }
}
