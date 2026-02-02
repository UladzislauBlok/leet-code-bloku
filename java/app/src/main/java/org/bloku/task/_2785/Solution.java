package org.bloku.task._2785;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sort Vowels in a String")
@Topics({STRING, SORTING})
class Solution {
  private static final Set<Character> VOWELS =
      Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public String sortVowels(String s) {
    int n = s.length();
    char[] chars = s.toCharArray();
    char[] sorted = new char[n];
    System.arraycopy(chars, 0, sorted, 0, n);
    Arrays.sort(sorted);
    int charPos = 0;
    int sortedPos = 0;
    while (charPos < n) {
      while (charPos < n && !VOWELS.contains(chars[charPos])) {
        charPos++;
      }
      if (charPos == n) break;
      while (sortedPos < n && !VOWELS.contains(sorted[sortedPos])) {
        sortedPos++;
      }
      chars[charPos++] = sorted[sortedPos++];
    }
    return new String(chars);
  }
}
