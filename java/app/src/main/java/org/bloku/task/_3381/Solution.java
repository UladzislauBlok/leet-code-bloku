package org.bloku.task._3381;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Subarray Sum With Length Divisible by K")
@Topics({ARRAY, PREFIX_SUM, SLIDING_WINDOW, KADANES_ALGORITHM})
class Solution {

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        long[] tmp = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        tmp[k - 1] = prefix[k - 1];
        long res = tmp[k - 1]; // first window
        for (int i = k; i < n; i++) {
            tmp[i] = tmp[i - k] + prefix[i] - prefix[i - k]; // prev + curr
            tmp[i] = Math.max(tmp[i], prefix[i] - prefix[i - k]); // just curr
            res = Math.max(res, tmp[i]);
        }
        return res;
    }

    public long maxSubarraySum_fromLeetCode(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++) {
            kSum[i] = Long.MAX_VALUE / 2;
        }
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }

    /*
        First idea: this is about sliding window of size n, where n % k == 0
        For every point I can do two operations:
            1) start from current one
            2) continue from result from prev one
        there is also for this (don't remember name)
        idea: for(num : nums) max_res = max(curr, prev + curr)
        We need to recalculate sum in window of size k
        For optimization we can use prefix sum
    */
}
