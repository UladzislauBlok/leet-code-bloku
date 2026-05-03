package org.bloku.task._3819;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Rotate Non Negative Elements")
@Topics({ARRAY, SIMULATION})
class Solution {

  public int[] rotateElements(int[] nums, int k) {
    List<Integer> positive = new ArrayList<>();
    for (int num : nums) {
      if (num >= 0) positive.add(num);
    }
    if (positive.size() < 2 || k % positive.size() == 0) return nums;
    k = k % positive.size();
    positive.addAll(positive.subList(0, k));
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < 0) continue;
      nums[i] = positive.removeLast();
    }
    return nums;
  }
}
