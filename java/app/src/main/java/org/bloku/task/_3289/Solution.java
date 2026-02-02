package org.bloku.task._3289;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("The Two Sneaky Numbers of Digitville")
@Topics({ARRAY, HASH_TABLE})
class Solution {

  public int[] getSneakyNumbers(int[] nums) {
    int n = nums.length;
    int[] map = new int[n];
    int[] res = new int[2];
    res[0] = -1;
    for (int num : nums) {
      if (map[num]++ == 1) {
        if (res[0] == -1) {
          res[0] = num;
        } else {
          res[1] = num;
        }
      }
    }
    return res;
  }
}
