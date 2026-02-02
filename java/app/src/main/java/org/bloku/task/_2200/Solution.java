package org.bloku.task._2200;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find All K-Distant Indices in an Array")
@Topics({ARRAY, TWO_POINTERS})
class Solution {

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> res = new ArrayList<>();
    int r = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == key) {
        int l = Math.max(r, i - k);
        r = Math.min(n - 1, i + k) + 1;
        while (l < r) res.add(l++);
      }
    }
    return res;
  }
}
