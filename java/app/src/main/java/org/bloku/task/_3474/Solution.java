package org.bloku.task._3474;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Lexicographically Smallest Generated String")
@Topics({STRING, GREEDY})
class Solution {

  public String generateString(String str1, String str2) {
    int n = str1.length(), m = str2.length();
    char[] result = new char[n + m - 1];
    boolean[] cantChange = new boolean[n + m - 1];
    Arrays.fill(result, 'a');
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    for (int i = 0; i < n; i++) {
      if (s1[i] == 'T') {
        for (int j = 0; j < m; j++) {
          if (cantChange[i + j] && result[i + j] != s2[j]) return "";
          result[i + j] = s2[j];
          cantChange[i + j] = true;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (s1[i] == 'F') {
        if (!equals(i, result, s2)) continue;
        int rightMost = -1;
        for (int j = i + m - 1; j >= i; j--) {
          if (!cantChange[j]) {
            rightMost = j;
            break;
          }
        }
        if (rightMost == -1) return "";
        result[rightMost] = 'b';
      }
    }
    return new String(result);
  }

  private boolean equals(int pos, char[] a, char[] b) {
    int n = b.length;
    for (int i = 0; i < n; i++) {
      if (a[pos + i] != b[i]) return false;
    }
    return true;
  }

  /*
      When we have T, we just add entire str2 (we need to check prefix)
      When we have F, if you may already have symbol
      Is it kind of greedy problem, but it's tricky
      Can we make it some different? Maybe we can try to add every symbol for every place, if fail fast
      Maybe we can try to add every symbol when see F?
      And result would be the first who can reach out the end
      is it kind of backtracking then?
      for verification, we can go with sliding window
  */
}
