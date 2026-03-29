package org.bloku.task._2840;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check if Strings Can be Made Equal With Operations II")
@Topics({STRING, SORTING, HASH_TABLE})
class Solution {

  public boolean checkStrings(String s1, String s2) {
    int n = s1.length();
    char[] chars1Even = new char[n / 2 + n % 2];
    char[] chars1Odd = new char[n / 2];
    char[] chars2Even = new char[n / 2 + n % 2];
    char[] chars2Odd = new char[n / 2];
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        chars1Even[i / 2] = s1.charAt(i);
        chars2Even[i / 2] = s2.charAt(i);
      } else {
        chars1Odd[i / 2] = s1.charAt(i);
        chars2Odd[i / 2] = s2.charAt(i);
      }
    }
    Arrays.sort(chars1Even);
    Arrays.sort(chars2Even);
    Arrays.sort(chars1Odd);
    Arrays.sort(chars2Odd);
    return Arrays.equals(chars1Even, chars2Even) && Arrays.equals(chars1Odd, chars2Odd);
  }
}
