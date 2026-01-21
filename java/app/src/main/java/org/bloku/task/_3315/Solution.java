package org.bloku.task._3315;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.List;

@LeetCodeName("Construct the Minimum Bitwise Array II")
@Topics({ARRAY, BIT_MANIPULATION})
class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int bit = 1;
            int res = -1;
            while ((num & bit) != 0) {
                res = num - bit;
                bit <<= 1;
            }
            ans[i] = res;
        }
        return ans;
    }

    /*
        same idea as yesterday, but numbers are much bigger
        we need to base solution on bit manipulation
        the idea is that when we're doing num|num+1
        we set least significant 0 bit to 1
        and to find a solution we need to find most left tailing 1 bit
        e.g., 1100111 = 103
                  ^
                this one
        and then 'exclude it' -> 1100011 | 1100100 =  99   |   100
                              this is answer        answer
    */
}
