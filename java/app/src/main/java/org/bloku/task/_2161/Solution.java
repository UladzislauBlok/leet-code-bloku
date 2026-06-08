package org.bloku.task._2161;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Partition Array According to Given Pivot")
@Topics({ARRAY, TWO_POINTERS})
class Solution {

  public int[] pivotArray(int[] nums, int pivot) {
    int n = nums.length;
    int[] result = new int[n];
    int leftPointer = 0;
    int rightPointer = n - 1;
    for (int i = 0; i < n; i++) {
      if (nums[i] < pivot) {
        result[leftPointer++] = nums[i];
      }
      int j = n - 1 - i;
      if (nums[j] > pivot) {
        result[rightPointer--] = nums[j];
      }
    }
    while (leftPointer <= rightPointer) {
      result[leftPointer++] = pivot;
    }
    return result;
  }

  public int[] pivotArray_(int[] nums, int pivot) {
    List<Integer> smaller = new ArrayList<>();
    List<Integer> bigger = new ArrayList<>();
    int pivotCount = 0;
    for (int num : nums) {
      if (num < pivot) {
        smaller.add(num);
      } else if (num > pivot) {
        bigger.add(num);
      } else {
        pivotCount++;
      }
    }
    int[] result = new int[nums.length];
    int resultPosition = 0;
    for (int num : smaller) {
      result[resultPosition++] = num;
    }
    for (int i = 0; i < pivotCount; i++) {
      result[resultPosition++] = pivot;
    }
    for (int num : bigger) {
      result[resultPosition++] = num;
    }
    return result;
  }

  /*
      I can brute force that with two lists, but we have memory overhead
      Overall it's about sorting with saving relative order
      kinda quick search which is also based on pivot
      ... but it will brake relative order
      ... actually any type of sorting is too complicated
  */
}
