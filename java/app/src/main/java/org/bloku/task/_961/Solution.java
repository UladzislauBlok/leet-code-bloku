package org.bloku.task._961;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("N-Repeated Element in Size 2N Array")
@Topics({ARRAY, HASH_TABLE})
class Solution {

    public int repeatedNTimes(int[] nums) {
        boolean[] set = new boolean[10001];
        for (int num : nums) {
            if (set[num]) return num;
            set[num] = true;
        }
        return -1;
    }
}
