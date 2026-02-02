package org.bloku.task._2264;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Largest 3-Same-Digit Number in String")
@Topics({STRING, SLIDING_WINDOW})
class Solution {

  public String largestGoodInteger1(String num) {
    char res = '*';
    char[] chars = num.toCharArray();
    for (int i = 0; i < num.length() - 2; i++) {
      boolean unique = true;
      for (int j = i + 1; j < i + 3; j++) {
        if (chars[j] != chars[j - 1]) unique = false;
      }
      if (unique && res < chars[i]) res = chars[i];
    }
    if (res == '*') return "";
    String resS = res + "";
    return resS.repeat(3);
  }

  public String largestGoodInteger(String num) {
    String[] numbers = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
    for (String i : numbers) {
      if (num.contains(i)) {
        return i;
      }
    }
    return "";
  }
}
