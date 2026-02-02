package org.bloku.task._869;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Reordered Power of 2")
@Topics({
  HASH_TABLE,
  MATH,
  SORTING,
  COUNTING,
  ENUMERATION,
})
class Solution {

  public boolean reorderedPowerOf2(int n) {
    int count = counter(n);
    for (int i = 0; i < 30; ++i) if (counter(1 << i) == count) return true;
    return false;
  }

  private int counter(int n) {
    int count = 0;
    for (; n > 0; n /= 10) count += Math.pow(10, n % 10);
    return count;
  }

  private static final Map<Integer, List<int[]>> EXPECTED = preProcess();

  // Let start with pre-processing
  // int has only 32 numbers that are pow of 2
  // Then we can split n into separate digits
  // Ane check we can have some result from list
  public boolean reorderedPowerOf2_1(int n) {
    int[] digits = new int[10];
    while (n > 0) {
      digits[n % 10]++;
      n /= 10;
    }
    for (int[] expDigits : EXPECTED.getOrDefault(Arrays.hashCode(digits), List.of())) {
      if (Arrays.equals(digits, expDigits)) return true;
    }
    return false;
  }

  private static Map<Integer, List<int[]>> preProcess() {
    Map<Integer, List<int[]>> map = new HashMap<>();
    int[] digits = new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    map.putIfAbsent(Arrays.hashCode(digits), new ArrayList<>());
    map.get(Arrays.hashCode(digits)).add(digits);
    int num = 1;
    for (int i = 1; i < 32; i++) {
      num *= 2;
      int temp = num;
      digits = new int[10];
      while (temp > 0) {
        digits[temp % 10]++;
        temp /= 10;
      }
      map.putIfAbsent(Arrays.hashCode(digits), new ArrayList<>());
      map.get(Arrays.hashCode(digits)).add(digits);
    }
    return map;
  }
}
