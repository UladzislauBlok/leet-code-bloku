package org.bloku.task._3228;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Number of Operations to Move Ones to the End")
@Topics({STRING, GREEDY, COUNTING})
class Solution {

  // looks simple. start on left most group of ones
  // move it one by one to the right most (or right boundary)
  public int maxOperations(String s) {
    int count = 0;
    int ones = 0;
    boolean zero = false;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        zero = true;
      } else {
        if (zero) {
          count += ones;
          zero = false;
        }
        ones++;
      }
    }
    if (zero) count += ones;
    return count;
  }
}
