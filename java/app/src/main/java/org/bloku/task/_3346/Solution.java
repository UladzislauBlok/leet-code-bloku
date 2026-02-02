package org.bloku.task._3346;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Frequency of an Element After Performing Operations I")
@Topics({ARRAY, HASH_TABLE, SLIDING_WINDOW, PREFIX_SUM})
class Solution {

  // each num can became any number in [num-k; num+k]
  // k is big, 0 <= k <= 10^5
  public int maxFrequency(int[] nums, int k, int numOperations) {
    int maxNum = 0;
    for (int num : nums) {
      maxNum = Math.max(maxNum, num);
    }
    int n = maxNum + 1;
    int[] f = new int[n];
    for (int num : nums) f[num]++;
    int right = 0;
    int left = 0;
    int max = 0;
    int window = 0;
    while (right < n) {
      if (right - left > k * 2) window -= f[left++];
      window += f[right];
      if (right < k) {
        right++;
        continue;
      }
      int curr = f[right - k];
      max = Math.max(max, curr + Math.min(window - curr, numOperations));
      right++;
    }
    int rest = right - k < 0 ? 0 : right - k;
    while (rest < n) {
      if (rest - left > k) window -= f[left++];
      int curr = f[rest];
      max = Math.max(max, curr + Math.min(window - curr, numOperations));
      rest++;
    }
    return max;
  }

  public int maxFrequencyPrefix(int[] nums, int k, int numOperations) {
    int max = 0, min = Integer.MAX_VALUE;

    for (int i : nums) {
      max = Math.max(max, i);
      min = Math.min(min, i);
    }

    int[] freq = new int[max + 1];
    int[] prefix = new int[max + 1];
    for (int i : nums) {
      freq[i]++;
    }
    for (int i = min; i <= max; i++) {
      prefix[i] = prefix[i - 1] + freq[i];
    }
    int ans = 0;
    for (int i = min; i <= max; i++) {
      int low = 0;
      if (i - k - 1 > 0) {
        low = prefix[i - k - 1];
      }
      int high = 0;
      if (i + k <= max) {
        high = prefix[i + k];
      } else {
        high = prefix[max];
      }
      int toChange = high - low - freq[i];
      ans = Math.max(ans, freq[i] + Math.min(numOperations, toChange));
    }
    return ans;
  }

  /*
      [1,3,4,5,6,4,4,9] - 3 - 4 -> 7
      [[1;1], [2;0] [3;1], [4;3], [5;1], [6;1], | [9;1]]
      frequency + sliding window + limitation numOps
      aggregate on max frequency
  */ }
