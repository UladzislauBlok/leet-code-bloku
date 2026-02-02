package org.bloku.task._3350;

import static org.bloku.util.Topic.*;

import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Adjacent Increasing Subarrays Detection II")
@Topics({ARRAY})
class Solution {

  public int maxIncreasingSubarrays(List<Integer> nums) {
    int n = nums.size();
    int prev = 1;
    int curr = 1;
    int max = 1;
    for (int i = 1; i < n; i++) {
      if (nums.get(i) > nums.get(i - 1)) curr++;
      else {
        prev = curr;
        curr = 1;
      }
      max = Math.max(max, curr / 2);
      max = Math.max(max, Math.min(prev, curr));
    }
    return max;
  }
}
