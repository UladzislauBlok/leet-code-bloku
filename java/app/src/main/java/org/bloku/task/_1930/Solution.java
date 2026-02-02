package org.bloku.task._1930;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Unique Length-3 Palindromic Subsequences")
@Topics({STRING, HASH_TABLE})
class Solution {

  public int countPalindromicSubsequence(String s) {
    boolean[] palindromes = new boolean[2700];
    int[] pos = new int[26];
    Arrays.fill(pos, -1);
    int[] count = new int[26]; // for aaa cases
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int ci = chars[i] - 'a';
      for (int j = 0; j < 26; j++) {
        if ((j == ci && count[ci] >= 2)
            || (j != ci && pos[j] != -1 && pos[ci] != -1 && pos[ci] < pos[j]))
          palindromes[ci * 100 + j] = true;
      }
      pos[ci] = i;
      count[ci]++;
    }
    int res = 0;
    for (boolean bool : palindromes) if (bool) res++;
    return res;
  }

  public int countPalindromicSubsequenceSet(String s) {
    Set<Integer> palindromes = new HashSet<>();
    int[] pos = new int[26];
    Arrays.fill(pos, -1);
    int[] count = new int[26]; // for aaa cases
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int ci = chars[i] - 'a';
      for (int j = 0; j < 26; j++) {
        if ((j == ci && count[ci] >= 2)
            || (j != ci && pos[j] != -1 && pos[ci] != -1 && pos[ci] < pos[j])) {
          palindromes.add(ci * 10000 + j * 100 + ci);
        }
      }
      pos[ci] = i;
      count[ci]++;
    }
    return palindromes.size();
  }
}
