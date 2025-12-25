package org.bloku.task._3075;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;

@LeetCodeName("Maximize Happiness of Selected Children")
@Topics({ARRAY, GREEDY, SORTING})
class Solution {

    // straightforward approach
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        int turn = 0, n = happiness.length;
        for (int i = n - 1; i >= n - k; i--) {
            int diff = happiness[i] - turn;
            if (diff <= 0) break;
            res += diff;
            turn++;
        }
        return res;
    }
}
