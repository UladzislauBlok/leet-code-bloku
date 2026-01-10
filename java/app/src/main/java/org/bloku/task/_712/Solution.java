package org.bloku.task._712;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.HashMap;
import java.util.Map;

@LeetCodeName("Minimum ASCII Delete Sum for Two Strings")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

    private final Map<Integer, Integer> memo = new HashMap<>();

    private String s1;
    private int n1;
    private String s2;
    private int n2;

    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.n1 = s1.length();
        this.s2 = s2;
        this.n2 = s2.length();
        return dp(0, 0);
    }

    private int dp(int idx1, int idx2) {
        if (idx1 == n1 && idx2 == n2) return 0;
        int key = idx1 * 10000 + idx2;
        Integer val = memo.get(key);
        if (val != null) return val;
        if (idx1 == n1) return dp(idx1, idx2 + 1) + s2.charAt(idx2);
        if (idx2 == n2) return dp(idx1 + 1, idx2) + s1.charAt(idx1);
        int res = Integer.MAX_VALUE;
        char c1 = s1.charAt(idx1);
        char c2 = s2.charAt(idx2);
        if (c1 == c2) return dp(idx1 + 1, idx2 + 1);
        res = Math.min(res, dp(idx1 + 1, idx2) + c1);
        res = Math.min(res, dp(idx1, idx2 + 1) + c2);
        memo.put(key, res);
        return res;
    }
}
