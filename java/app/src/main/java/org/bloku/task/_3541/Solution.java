package org.bloku.task._3541;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Find Most Frequent Vowel and Consonant")
@Topics({Topic.STRING})
class Solution {

  public int maxFreqSum(String s) {
    int[] map = new int[128];
    int maxV = 0;
    int maxC = 0;
    for (char c : s.toCharArray()) {
      map[c]++;
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        maxV = Math.max(maxV, map[c]);
      } else {
        maxC = Math.max(maxC, map[c]);
      }
    }
    return maxV + maxC;
  }
}
