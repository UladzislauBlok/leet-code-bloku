package org.bloku.task._1437;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check If All 1's Are at Least Length K Places Away")
@Topics({ARRAY})
class Solution {

  public boolean kLengthApart(int[] nums, int k) {
    int count = 0;
    boolean skip = true;
    for (int num : nums) {
      if (num == 0) {
        count++;
      } else {
        if (count < k && !skip) return false;
        count = 0;
        skip = false;
      }
    }
    return true;
  }
}
