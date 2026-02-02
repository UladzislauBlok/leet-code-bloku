package org.bloku.task._2570;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Merge Two 2D Arrays by Summing Values")
@Topics({ARRAY, HASH_TABLE, TWO_POINTERS})
class Solution {

  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    int[] map = new int[1001];
    int counter = 0;
    for (int[] ints : nums1) {
      int key = ints[0];
      int value = ints[1];
      if (map[key] == 0) {
        counter++;
      }
      map[key] += value;
    }
    for (int[] ints : nums2) {
      int key = ints[0];
      int value = ints[1];
      if (map[key] == 0) {
        counter++;
      }
      map[key] += value;
    }
    int[][] result = new int[counter][2];
    int resultIndex = 0;
    for (int i = 0; i < map.length; i++) {
      if (map[i] == 0) continue;
      result[resultIndex][0] = i;
      result[resultIndex][1] = map[i];
      resultIndex++;
    }
    return result;
  }
}
