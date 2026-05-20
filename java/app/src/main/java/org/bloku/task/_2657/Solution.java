package org.bloku.task._2657;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Prefix Common Array of Two Arrays")
@Topics({ARRAY, HASH_TABLE})
class Solution {

  public int[] findThePrefixCommonArray(int[] A, int[] B) {
    if (A.length != B.length) {
      return new int[0];
    }
    int n = A.length;
    int[] frequency = new int[n + 1];
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        result[i] = result[i - 1];
      }
      frequency[A[i]]++;
      result[i] += frequency[A[i]] == 2 ? 1 : 0;

      frequency[B[i]]++;
      result[i] += frequency[B[i]] == 2 ? 1 : 0;
    }
    return result;
  }
}
