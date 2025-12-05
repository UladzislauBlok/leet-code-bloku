package org.bloku.task._3432;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Partitions with Even Sum Difference")
@Topics({ARRAY, PREFIX_SUM})
class Solution {

    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        int res = 0;
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            if (Math.abs(sum - 2 * left) % 2 == 0) res++;
        }
        return res;
    }

    // standart prefix sum
    public int countPartitionsPrefix(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i];
        int res = 0;
        for (int i = 1; i < n; i++) if (Math.abs(2 * prefix[i - 1] - prefix[n - 1]) % 2 == 0) res++;
        return res;
    }
}
