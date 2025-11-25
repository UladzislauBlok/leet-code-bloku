package org.bloku.task._1015;

import static org.bloku.util.Topic.MATH;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Smallest Integer Divisible by K")
@Topics({MATH})
class Solution {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int num = 0;
        for (int i = 0; i < k; i++) {
            num %= k;
            num = num * 10 + 1;
            if (num % k == 0) return i + 1;
        }
        return -1;
    }
}
