package org.bloku.task._3886;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sum of Sortable Integers")
@Topics({ARRAY, MATH, SORTING, DIVIDE_AND_CONQUER})
class Solution {

  public int sortableIntegers(int[] nums) {
    int n = nums.length;
    if (n == 1) return 1;
    List<Integer> allK = findAllK(n);
    if (sorted(nums)) {
      int sum = 1;
      for (int k : allK) sum += k;
      return sum;
    }
    int sum = 0;
    for (int k : allK) {
      boolean good = true;
      int prevMax = -1;
      for (int i = 0; i < n; i += k) {
        int prevNum = -1, decreased = 0, localMax = -1, localMin = Integer.MAX_VALUE;
        for (int j = i; j < i + k; j++) {
          if (prevNum > nums[j]) decreased++;
          prevNum = nums[j];
          localMax = Math.max(localMax, nums[j]);
          localMin = Math.min(localMin, nums[j]);
        }
        if (decreased > 1) {
          good = false;
          break;
        } else if (decreased == 1 && nums[i] < nums[i + k - 1]) {
          good = false;
          break;
        } else if (prevMax > localMin) {
          good = false;
          break;
        }
        prevMax = localMax;
      }
      if (good) sum += k;
    }
    return sum;
  }

  private boolean sorted(int[] nums) {
    int prev = -1;
    for (int num : nums) {
      if (prev > num) return false;
      prev = num;
    }
    return true;
  }

  private List<Integer> findAllK(int n) {
    List<Integer> list = new ArrayList<>();
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i < sqrt; i++) {
      if (n % i == 0) {
        list.add(i);
        list.add(n / i);
      }
    }
    if (sqrt * sqrt == n) list.add(sqrt);
    list.add(n);
    return list;
  }

  /*
      how to check that partition of size n can be sorted using rotation?
      it should be already sorted, but rotated
      I think if nums isn't sorted we have only one option how to sort it,
      if it's already sorted -> we need to find all possible k
      how many options we have for partitioning?

      1,2,3,4,5
      3,4,5,1,2
      4,5,1,2,3
  */
}
