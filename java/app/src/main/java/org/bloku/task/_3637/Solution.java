package org.bloku.task._3637;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Trionic Array I")
@Topics({ARRAY})
class Solution {

  public boolean isTrionic(int[] nums) {
    int n = nums.length, i = 1;
    while (i < n && nums[i] > nums[i - 1]) i++;
    if (i == n || i == 1) return false;
    while (i < n && nums[i] < nums[i - 1]) i++;
    if (i == n) return false;
    while (i < n && nums[i] > nums[i - 1]) i++;
    if (i != n) return false;
    return true;
  }
}
