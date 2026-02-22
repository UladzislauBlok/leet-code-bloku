package org.bloku.task._761;

import static org.bloku.util.Topic.*;

import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Special Binary String")
@Topics({STRING, DIVIDE_AND_CONQUER, GREEDY})
class Solution {

  private final Set<String> visited = new HashSet<>();

  public String makeLargestSpecial(String s) {
    if (!visited.add(s)) return "-1";
    int n = s.length();
    char[] chars = s.toCharArray();
    char[] swap = new char[n];
    char[] tmp = new char[n];
    String res = s;
    for (int i = 0; i < n; i++) {
      int end = checkSpecial(chars, i);
      if (end == -1 || end == n - 1) continue;
      int secondEnd = checkSpecial(chars, end + 1);
      if (secondEnd == -1) continue;
      System.arraycopy(chars, 0, swap, 0, n);
      System.arraycopy(chars, i, tmp, 0, end - i + 1);
      for (int j = 0; j < secondEnd - end; j++) {
        swap[i + j] = chars[end + 1 + j];
      }
      for (int j = 0; j < end - i + 1; j++) {
        swap[i + secondEnd - end + j] = tmp[j];
      }
      String swaped = new String(swap);
      if (res.compareTo(swaped) >= 0) continue;
      res = makeLargestSpecial(swaped);
    }
    return res;
  }

  private int checkSpecial(char[] chars, int start) {
    int[] count = new int[2];
    for (int i = start; i < chars.length; i++) {
      count[chars[i] - '0']++;
      if (count[1] < count[0]) return -1;
      if (count[0] == count[1]) return i;
    }
    return -1;
  }
}
