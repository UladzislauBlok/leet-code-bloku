package org.bloku.task._3227;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Vowels Game in a String")
@Topics({Topic.MATH})
class Solution {

  public boolean doesAliceWin(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'a', 'e', 'i', 'o', 'u':
          return true;
      }
    }
    return false;
  }
}
