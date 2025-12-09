package org.bloku.task._3583;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Special Triplets")
@Topics({ARRAY, HASH_TABLE, COUNTING})
class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int[][] map = new int[n][2];
        int max = -1;
        for (int num : nums) max = Math.max(max, num);
        int[] f = new int[max * 2 + 1];
        for (int i = 0; i < n; i++) {
            map[i][0] = f[nums[i] * 2];
            f[nums[i]]++;
        }
        f = new int[max * 2 + 1];
        for (int i = n - 1; i >= 0; i--) {
            map[i][1] = f[nums[i] * 2];
            f[nums[i]]++;
        }
        // System.out.println(Arrays.deepToString(map));
        int res = 0;
        for (int[] pair : map) res = (int) (res + (1L * pair[0] * pair[1]) % MOD) % MOD;
        return res;
    }

    /*
        Mapping + math?
        I can base my solution on middle number (nums[j])
        For every occurency of nums[j] I need to know how many occurency of nums[j] * 2
        was on right and left sides
        There is good hint: for every nums[j], we're unterested only in nums[j] * 2
    */
}
