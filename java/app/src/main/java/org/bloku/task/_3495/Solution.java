package org.bloku.task._3495;

import static org.bloku.util.Topic.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Operations to Make Array Elements Zero")
@Topics({ARRAY, MATH})
class Solution {

  // We know how many operation we have to do for each num
  // It's about intervals
  // e.g.
  // 0-3 - 1 operation
  // 4-15 - 2 operations
  // 16-63 - 3 operations
  // we can precalculate those intervals and use for queries

  private static final SequencedMap<int[], Integer> map = new LinkedHashMap<>();

  static {
    map.put(new int[] {0, 3}, 1);
    map.put(new int[] {4, 15}, 2);
    map.put(new int[] {16, 63}, 3);
    map.put(new int[] {64, 255}, 4);
    map.put(new int[] {256, 1023}, 5);
    map.put(new int[] {1024, 4095}, 6);
    map.put(new int[] {4096, 16383}, 7);
    map.put(new int[] {16384, 65535}, 8);
    map.put(new int[] {65536, 262143}, 9);
    map.put(new int[] {262144, 1048575}, 10);
    map.put(new int[] {1048576, 4194303}, 11);
    map.put(new int[] {4194304, 16777215}, 12);
    map.put(new int[] {16777216, 67108863}, 13);
    map.put(new int[] {67108864, 268435455}, 14);
    map.put(new int[] {268435456, 1000000000}, 15); // 1e9 is max
  }

  public long minOperationsMap(int[][] queries) {
    long count = 0;
    for (int[] query : queries) {
      long ops = 0;
      for (Map.Entry<int[], Integer> limit : map.entrySet()) {
        if (query[1] < limit.getKey()[0]) break;
        if (query[0] > limit.getKey()[1]) continue;
        int lowBound = Math.max(query[0], limit.getKey()[0]);
        int upperBound = Math.min(query[1], limit.getKey()[1]);
        ops += (upperBound - lowBound + 1L) * limit.getValue();
      }
      count += ops / 2;
      count += ops & 1;
    }
    return count;
  }

  public long minOperations1(int[][] queries) {
    long count = 0;
    for (int[] query : queries) {
      long ops = 0;
      for (long d = 1, prev = 1; d < 17; d++) {
        long cur = prev * 4;
        long l = Math.max(query[0], prev);
        long r = Math.min(query[1], cur - 1);
        if (r >= l) {
          ops += (r - l + 1) * d;
        }
        prev = cur;
      }
      count += (ops + 1) / 2;
    }
    return count;
  }

  public long minOperations(int[][] queries) {
    long res = 0;
    for (int[] query : queries) res += minOperations(query);
    return res;
  }

  public static long minOperations(int[] query) {
    long d = 0;
    long x = 1;
    while (x < query[0]) {
      d++;
      x *= 4;
    }
    long res = 0;
    long prev = query[0];
    while (x <= query[1] * 4L) {
      res += d * (Math.min(x, query[1] + 1) - prev);
      prev = x;
      d++;
      x *= 4;
    }
    return (res + 1) / 2;
  }
}
