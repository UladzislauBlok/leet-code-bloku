package org.bloku.task._1411;

import static org.bloku.util.Topic.DYNAMIC_PROGRAMMING;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LeetCodeName("Number of Ways to Paint N × 3 Grid")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

    private static final int MOD = (int) 1e9 + 7;

    private final Map<Integer, Integer> memo = new HashMap<>();
    private int n;
    private List<Integer>[] next;

    /*
        r y r -> g r y / y r g + g r g / y r y / y g y -> aba * 2 + aba * 3
        r y g -> g r y / y g r + y r y / y g y -> abc * 2 + abc * 2
    */
    public int numOfWays(int n) {
        long aba = 6; // ABA pattern is like Red-Yellow-Red
        long abc = 6; // ABC pattern is like Red-Yellow-Green
        while (n > 1) {
            long new_aba = (aba * 3 + abc * 2) % MOD; // 3 ways to aba from ABA + 2 ways from ABC
            long new_abc = (aba * 2 + abc * 2) % MOD; // 2 ways to aba from ABA + 2 ways from ABC
            n--;
            aba = new_aba;
            abc = new_abc;
        }
        return (int) ((aba + abc) % MOD);
    }

    public int numOfWays_dp(int n) {
        this.n = n;
        int[][] rows = new int[12][3];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        rows[idx][0] = i;
                        rows[idx][1] = j;
                        rows[idx][2] = k;
                        idx++;
                    }
                }
            }
        }
        this.next = new ArrayList[12];
        for (int i = 0; i < 12; i++) {
            next[i] = new ArrayList<>();
            int[] row = rows[i];
            for (int j = 0; j < 12; j++) {
                int[] nextRow = rows[j];
                boolean good = true;
                for (int k = 0; k < 3; k++) if (row[k] == nextRow[k]) good = false;
                if (good) next[i].add(j);
            }
        }
        int res = 0;
        for (int i = 0; i < 12; i++) {
            res = (res + dp(1, i)) % MOD;
        }
        return res;
    }

    private int dp(int rowIdx, int prevRowIdx) {
        if (rowIdx == n) return 1;
        int key = rowIdx * 100 + prevRowIdx;
        Integer val = memo.get(key);
        if (val != null) return val;
        int res = 0;
        for (int nextRowIdx : next[prevRowIdx]) res = (res + dp(rowIdx + 1, nextRowIdx)) % MOD;
        memo.put(key, res);
        return res;
    }
}
