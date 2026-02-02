package org.bloku.task._1935;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Number of Words You Can Type")
@Topics({Topic.STRING})
class Solution {

  public int canBeTypedWords(String text, String brokenLetters) {
    boolean[] bl = new boolean[26];
    for (char c : brokenLetters.toCharArray()) {
      bl[c - 'a'] = true;
    }
    boolean flag = false;
    int count = 0;
    for (char c : text.toCharArray()) {
      if (c == ' ') {
        count = flag ? count : count + 1;
        flag = false;
      } else if (!flag) {
        flag = bl[c - 'a'];
      }
    }
    return flag ? count : count + 1;
  }
}
