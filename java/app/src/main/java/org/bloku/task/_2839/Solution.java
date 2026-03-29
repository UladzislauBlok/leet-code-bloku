package org.bloku.task._2839;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check if Strings Can be Made Equal With Operations I")
@Topics({STRING, SORTING, GREEDY})
class Solution {

  public boolean canBeEqual(String s1, String s2) {
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();
    if (chars1[0] > chars1[2]) swap(0, 2, chars1);
    if (chars1[1] > chars1[3]) swap(1, 3, chars1);
    if (chars2[0] > chars2[2]) swap(0, 2, chars2);
    if (chars2[1] > chars2[3]) swap(1, 3, chars2);
    return Arrays.equals(chars1, chars2);
  }

  private void swap(int a, int b, char[] chars) {
    char tmp = chars[a];
    chars[a] = chars[b];
    chars[b] = tmp;
  }
}
