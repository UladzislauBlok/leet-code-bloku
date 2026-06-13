package org.bloku.task._3838;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Weighted Word Mapping")
@Topics({ARRAY, STRING})
class Solution {

  public String mapWordWeights(String[] words, int[] weights) {
    if (words == null || weights == null || weights.length != 26) {
      throw new IllegalArgumentException(
          "Invalid inputs: words cannot be null, weights must have length 26.");
    }
    StringBuilder result = new StringBuilder();
    for (String word : words) {
      if (word == null) {
        continue;
      }
      int charSum = 0;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (c < 'a' || c > 'z') {
          throw new IllegalArgumentException("Words must only contain lowercase English letters.");
        }
        int charIndex = c - 'a';
        charSum += weights[charIndex];
        charSum = Math.floorMod(charSum, 26);
      }
      char newChar = (char) ('z' - charSum);
      result.append(newChar);
    }
    return result.toString();
  }
}
