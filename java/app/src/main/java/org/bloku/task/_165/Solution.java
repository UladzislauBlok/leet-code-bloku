package org.bloku.task._165;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Compare Version Numbers")
@Topics({STRING, TWO_POINTERS})
class Solution {

  public int compareVersionSplit(String version1, String version2) {
    String[] v1 = version1.split("\\."); // :))
    String[] v2 = version2.split("\\.");
    int idx1 = 0, idx2 = 0;
    int n1 = v1.length, n2 = v2.length;
    while (idx1 < n1 && idx2 < n2) {
      int num1 = Integer.parseInt(v1[idx1++]);
      int num2 = Integer.parseInt(v2[idx2++]);
      if (num1 < num2) return -1;
      if (num1 > num2) return 1;
    }
    while (idx2 < n2) {
      int num = Integer.parseInt(v2[idx2++]);
      if (num != 0) return -1;
    }
    while (idx1 < n1) {
      int num = Integer.parseInt(v1[idx1++]);
      if (num != 0) return 1;
    }
    return 0;
  }

  public int compareVersion(String version1, String version2) {
    int i = 0, j = 0;
    int n = version1.length(), m = version2.length();
    while (i < n || j < m) {
      int num1 = 0, num2 = 0;
      while (i < n && version1.charAt(i) != '.') {
        num1 = num1 * 10 + (version1.charAt(i) - '0');
        i++;
      }
      while (j < m && version2.charAt(j) != '.') {
        num2 = num2 * 10 + (version2.charAt(j) - '0');
        j++;
      }
      if (num1 > num2) return 1;
      if (num1 < num2) return -1;
      if (i < n && version1.charAt(i) == '.') i++;
      if (j < m && version2.charAt(j) == '.') j++;
    }

    return 0;
  }
}
