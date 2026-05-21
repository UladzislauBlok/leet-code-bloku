package org.bloku.task._3043;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Length of the Longest Common Prefix")
@Topics({TRIE})
class Solution {

  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    Trie trie = new Trie(0);
    for (int num : arr1) {
      int divisor = findDivisor(num);
      trie.add(num, divisor);
    }
    int result = 0;
    for (int num : arr2) {
      int divisor = findDivisor(num);
      result = Math.max(result, trie.find(num, divisor));
    }
    return result;
  }

  private int findDivisor(int num) {
    int divisor = 100000000;
    while (divisor > num) {
      divisor /= 10;
    }
    return divisor;
  }

  private static final class Trie {

    private final Trie[] children;
    private final int level;

    Trie(int level) {
      children = new Trie[10];
      this.level = level;
    }

    void add(int num, int divisor) {
      int child = num / divisor;
      if (children[child] == null) {
        children[child] = new Trie(level + 1);
      }
      if (divisor > 1) {
        children[child].add(num % divisor, divisor / 10);
      }
    }

    int find(int num, int divisor) {
      if (divisor == 0) {
        return level;
      }
      int child = num / divisor;
      if (children[child] == null) {
        return level;
      }
      return children[child].find(num % divisor, divisor / 10);
    }
  }
}
