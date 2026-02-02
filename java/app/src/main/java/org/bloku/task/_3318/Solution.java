package org.bloku.task._3318;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find X-Sum of All K-Long Subarrays I")
@Topics({ARRAY, HEAP_PRIORITY_QUEUE, HASH_TABLE})
class Solution {

  public int[] findXSumPq(int[] nums, int k, int x) {
    int n = nums.length;
    int[] f = new int[51]; // 50 is max num
    int left = 0, right = 0;
    int[] answer = new int[n - k + 1];
    int idx = 0;
    PriorityQueue<Tuple> pq =
        new PriorityQueue<>((a, b) -> b.f - a.f == 0 ? b.num - a.num : b.f - a.f);
    List<Tuple> used = new ArrayList<>();
    while (right < n) {
      if (right - left == k) {
        f[nums[left]]--;
        pq.remove(new Tuple(nums[left], f[nums[left]] + 1));
        if (f[nums[left]] > 0) pq.add(new Tuple(nums[left], f[nums[left]]));
        left++;
      }
      f[nums[right]]++;
      pq.remove(new Tuple(nums[right], f[nums[right]] - 1));
      pq.add(new Tuple(nums[right], f[nums[right]]));
      if (right - left + 1 == k) {
        int count = 0, res = 0;
        while (!pq.isEmpty() && count < x) {
          Tuple entry = pq.poll();
          used.add(entry);
          count++;
          res += entry.num * entry.f;
        }
        answer[idx++] = res;
        for (Tuple back : used) pq.add(back);
        used.clear();
      }
      right++;
    }
    return answer;
  }

  public int[] findXSum(int[] nums, int k, int x) {
    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i < result.length; i++) {
      int left = i, right = i + k - 1;
      result[i] = findXSumofSubArray(nums, left, right, x);
    }

    return result;
  }

  private int findXSumofSubArray(int[] nums, int left, int right, int x) {
    int sum = 0, distinctCount = 0;
    int[] freq = new int[51];
    for (int i = left; i <= right; i++) {
      sum += nums[i];
      if (freq[nums[i]] == 0) {
        distinctCount++;
      }
      freq[nums[i]]++;
    }
    if (distinctCount < x) {
      return sum;
    }
    sum = 0;
    for (int pick = 0; pick < x; pick++) {
      int bestFreq = -1;
      int bestVal = -1;
      for (int val = 50; val >= 1; val--) {
        if (freq[val] > bestFreq) {
          bestFreq = freq[val];
          bestVal = val;
        }
      }
      if (bestVal != -1) {
        sum += bestVal * bestFreq;
        freq[bestVal] = 0;
      }
    }
    return sum;
  }

  private record Tuple(int num, int f) {}
}
