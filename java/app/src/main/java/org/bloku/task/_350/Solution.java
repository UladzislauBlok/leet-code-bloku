package org.bloku.task._350;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Intersection of Two Arrays II")
@Topics({HASH_TABLE, TWO_POINTERS})
class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    int[] map = new int[1001];
    for (int num : nums1) map[num]++;
    List<Integer> result = new ArrayList<>();
    for (int num : nums2) {
      if (map[num]-- > 0) result.add(num);
    }
    int[] array = new int[result.size()];
    for (int i = 0; i < result.size(); i++) array[i] = result.get(i);
    return array;
  }
}
