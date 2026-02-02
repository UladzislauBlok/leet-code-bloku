package org.bloku.task._3461;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check If Digits Are Equal in String After Operations I")
@Topics({STRING, SIMULATION})
class Solution {

  public boolean hasSameDigits(String s) {
    char[] chars = s.toCharArray();
    int n = s.length();
    while (n > 2) {
      for (int i = 0; i < n - 1; i++) {
        chars[i] = (char) (((chars[i] + chars[i + 1] - 2 * '0') % 10) + '0');
      }
      // System.out.println(Arrays.toString(chars));
      n--;
    }
    return chars[0] == chars[1];
  }
}
