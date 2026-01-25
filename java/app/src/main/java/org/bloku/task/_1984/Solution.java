package org.bloku.task._1984;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;

@LeetCodeName("Minimum Difference Between Highest and Lowest of K Scores")
@Topics({ARRAY, SLIDING_WINDOW, SORTING})
class Solution {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        int n = nums.length, res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= n - k; i++) res = Math.min(res, nums[i + k - 1] - nums[i]);
        return res;
    }
}
