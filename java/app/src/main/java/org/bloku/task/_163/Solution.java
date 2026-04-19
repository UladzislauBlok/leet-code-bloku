package org.bloku.task._163;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Missing Ranges")
@Topics({ARRAY})
class Solution {

  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    int n = nums.length;
    if (n == 0) return List.of(List.of(lower, upper));
    List<List<Integer>> result = new ArrayList<>();
    if (lower < nums[0]) result.add(List.of(lower, nums[0] - 1));
    for (int i = 0; i < n - 1; i++) {
      if (nums[i + 1] - nums[i] == 1) continue;
      result.add(List.of(nums[i] + 1, nums[i + 1] - 1));
    }
    if (upper > nums[n - 1]) result.add(List.of(nums[n - 1] + 1, upper));
    return result;
  }
}
