package org.bloku.task._1871;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Jump Game VII")
@Topics({STRING, DYNAMIC_PROGRAMMING, PREFIX_SUM, SLIDING_WINDOW})
class Solution {

  public boolean canReach(String sequence, int minJump, int maxJump) {
    int length = sequence.length();
    if (length == 0 || sequence.charAt(length - 1) == '1') {
      return false;
    }
    int[] reachablePrefixSum = new int[length];
    int initialWindowLimit = Math.min(length, minJump);
    for (int i = 0; i < initialWindowLimit; i++) {
      reachablePrefixSum[i] = 1;
    }
    for (int i = minJump; i < length; i++) {
      if (sequence.charAt(i) == '0') {
        int windowLeftBound = i - maxJump;
        int windowRightBound = i - minJump;
        int leftContribution = (windowLeftBound > 0) ? reachablePrefixSum[windowLeftBound - 1] : 0;
        int reachableCountInWindow = reachablePrefixSum[windowRightBound] - leftContribution;
        if (reachableCountInWindow > 0) {
          reachablePrefixSum[i]++;
          if (i == length - 1) {
            return true;
          }
        }
      }
      reachablePrefixSum[i] += reachablePrefixSum[i - 1];
    }

    return false;
  }
}
