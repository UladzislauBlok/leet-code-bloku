package org.bloku.task._67;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Add Binary")
@Topics({STRING, MATH, BIT_MANIPULATION})
class Solution {

  public String addBinary_(String a, String b) {
    int al = a.length(), bl = b.length();
    char[] res = new char[Math.max(al, bl)];
    int i = 0;
    int rest = 0;
    while (i < al && i < bl) {
      int ca = a.charAt(al - 1 - i) - '0';
      int cb = b.charAt(bl - 1 - i) - '0';
      int curr = ca + cb + rest;
      rest = curr / 2;
      res[Math.max(al, bl) - 1 - i] = (char) ((curr % 2) + 48);
      i++;
    }
    while (i < al) {
      int c = a.charAt(al - 1 - i) - '0';
      int curr = c + rest;
      rest = curr / 2;
      res[al - 1 - i] = (char) ((curr % 2) + 48);
      i++;
    }
    while (i < bl) {
      int c = b.charAt(bl - 1 - i) - '0';
      int curr = c + rest;
      rest = curr / 2;
      res[bl - 1 - i] = (char) ((curr % 2) + 48);
      i++;
    }
    String s = new String(res);
    if (rest != 0) return "1" + s;
    return s;
  }

  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0 || carry == 1) {
      int sum = carry;
      if (i >= 0) sum += a.charAt(i--) - '0';
      if (j >= 0) sum += b.charAt(j--) - '0';
      res.append(sum % 2);
      carry = sum / 2;
    }
    return res.reverse().toString();
  }
}
