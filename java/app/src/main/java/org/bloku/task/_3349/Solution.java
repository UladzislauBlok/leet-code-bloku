package org.bloku.task._3349;

import static org.bloku.util.Topic.*;

import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Adjacent Increasing Subarrays Detection I")
@Topics({ARRAY})
class Solution {

  public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    int n = nums.size();
    int prev = 1;
    int curr = 1;
    for (int i = 1; i < n; i++) {
      if (nums.get(i) > nums.get(i - 1)) curr++;
      else {
        prev = curr;
        curr = 1;
      }
      if (curr == k * 2 || prev >= k && curr >= k) return true;
    }
    return false;
  }
}
