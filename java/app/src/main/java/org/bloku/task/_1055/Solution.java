package org.bloku.task._1055;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Shortest Way to Form String")
@Topics({TWO_POINTERS, STRING, GREEDY})
class Solution {

  public int shortestWay(String source, String target) {
    char[] chars = source.toCharArray();
    int pos = 0, count = 0;
    int n = target.length();
    while (pos < n) {
      count++;
      int prev = pos;
      for (char c : chars) {
        if (c == target.charAt(pos)) pos++;
        if (pos == n) break;
      }
      if (prev == pos) return -1;
    }
    return count;
  }

  /*
      we can do kinda bfs/dfs, but I don't think that would be effective enough
      we need to minimize result, so maybe we can do it greedy way?
      we can iterate over source, and move target pointer as left as possible
      in worst case we'll need to iterate source.length * target.length() times, what is 1000 ^ 2 == 10^5

      abcz abc|abcz
      abcz abc|abcz|zzz

      abc xbc
      abc  bc

      axc xxx
      a c    d
  */
}
