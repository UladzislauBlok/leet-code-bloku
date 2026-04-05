package org.bloku.task._2075;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Decode the Slanted Ciphertext")
@Topics({STRING, SIMULATION})
class Solution {

  public String decodeCiphertext(String encodedText, int rows) {
    int n = encodedText.length();
    int offset = n / rows;
    StringBuilder sb = new StringBuilder();
    char[] chars = encodedText.toCharArray();
    for (int i = 0; i < offset; i++) {
      sb.append(chars[i]);
      for (int j = 1; j < rows; j++) {
        int pos = i + j * offset + j;
        if (pos < n) sb.append(chars[pos]);
      }
    }
    return sb.toString().stripTrailing();
  }
}
