package org.bloku.task._2438;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Range Product Queries of Powers")
@Topics({ARRAY, BIT_MANIPULATION, PREFIX_SUM})
class Solution {

  public int[] productQueries(int num, int[][] queries) {
    int power = 1, MOD = (int) 1e9 + 7;
    while (power <= num) power <<= 1;
    power >>= 1;
    List<Integer> powers = new ArrayList<>();
    while (num > 0) {
      if (power <= num) {
        powers.add(power);
        num -= power;
      }
      power >>= 1;
    }
    int n = powers.size();
    int[][] prefix = new int[n][n];
    for (int i = 0; i < n; i++) {
      prefix[i][i] = powers.get(n - 1 - i);
      for (int j = i + 1; j < n; j++)
        prefix[i][j] = (int) ((1L * prefix[i][j - 1] * powers.get(n - 1 - j)) % MOD);
    }

    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) res[i] = prefix[queries[i][0]][queries[i][1]];

    return res;
  }

  private static final int MOD = 1_000_000_007;

  // 1. find max num with one bit eq to 1
  // 2. -= from n
  // 3. re-run steps 1 and 2 until n > 0
  // 4. process queries
  public int[] productQueries1(int num, int[][] queries) {
    List<Integer> list = new ArrayList<>();
    while (num > 0) {
      int pow = 1;
      while (num >= pow) {
        pow = pow << 1;
      }
      pow = pow >> 1;
      num -= pow;
      list.addFirst(pow);
    }
    int n = queries.length;
    int[] res = new int[n];
    // System.out.println(list);
    for (int i = 0; i < n; i++) {
      long prod = 1;
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        // System.out.println(i+":"+res[i] * list.get(j));
        prod = (prod * list.get(j)) % MOD;
      }
      res[i] = (int) prod; // safe because of mod
    }
    return res;
  }
}
