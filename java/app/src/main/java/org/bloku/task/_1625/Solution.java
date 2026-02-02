package org.bloku.task._1625;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Lexicographically Smallest String After Applying Operations")
@Topics({STRING, BFS, DFS})
class Solution {

  public String findLexSmallestString(String s, int a, int b) {
    String res = s;
    int n = s.length();
    Set<String> seen = new HashSet<>();
    Queue<String> queue = new ArrayDeque<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      String str = queue.poll();
      if (res.compareTo(str) > 0) res = str;
      char[] chars = str.toCharArray();
      for (int i = 1; i < n; i += 2) {
        chars[i] += a;
        if (chars[i] > '9') chars[i] = (char) ((chars[i] % ('9' + 1)) + '0');
      }
      String addStr = new String(chars);
      if (seen.add(addStr)) queue.add(addStr);
      String rotateStr = str.substring(n - b, n) + str.substring(0, n - b);
      if (seen.add(rotateStr)) queue.add(rotateStr);
    }
    return res;
  }
}
