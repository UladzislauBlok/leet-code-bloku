package org.bloku.task._1733;

import static org.bloku.util.Topic.*;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Number of People to Teach")
@Topics({ARRAY, GREEDY, BIT_MANIPULATION})
class Solution {

  // key is here that only one languages can be chosen
  // we can preprocess languages / friendships and that try to 'crack' it with each lang
  // 2 <= n <= 500
  // 1 <= m <= 500
  // preprocess languages to be a set for effective lookup
  // to verbose, to be refactored with bitmask (bitset)
  public int minimumTeachings(int n, int[][] L, int[][] F) {
    int m = L.length;
    BitSet[] langs = new BitSet[m + 1];
    for (int i = 1; i <= m; i++) {
      langs[i] = new BitSet(n + 1);
      for (int lang : L[i - 1]) {
        langs[i].set(lang);
      }
    }
    Set<Integer> teach = new HashSet<>();
    for (int[] pair : F) {
      BitSet diff = (BitSet) langs[pair[0]].clone();
      diff.and(langs[pair[1]]);
      if (diff.length() == 0) {
        teach.add(pair[0]);
        teach.add(pair[1]);
      }
    }
    int max = Integer.MIN_VALUE; // searching for most known language
    for (int i = 1; i <= n; i++) {
      int count = 0;
      for (int p : teach) {
        if (langs[p].get(i)) count++;
      }
      max = Math.max(max, count);
    }
    return teach.size() - max;
  }
}
