package org.bloku.task._3562;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LeetCodeName("Maximum Profit from Trading Stocks with Discounts")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, TREE, DFS})
class Solution {

    private final Map<Integer, List<Integer>> hierarchy = new HashMap<>();
    private int[] present;
    private int[] future;
    private final Map<Integer, Integer> memo0 = new HashMap<>();
    private final Map<Integer, Integer> memo1 = new HashMap<>();

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        for (int[] pair : hierarchy)
            this.hierarchy.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        this.present = present;
        this.future = future;
        return dp0(1, false, budget);
    }

    private int dp0(int employee, boolean discount, int budget) {
        int key = employee * 10000 + budget * 10 + (discount ? 1 : 0);
        // if (memo0.containsKey(key))
        //     return memo0.get(key);
        Integer cache = memo0.get(key);
        if (cache != null) return cache;
        int price = discount ? present[employee - 1] / 2 : present[employee - 1];
        int buyProfit = 0;
        if (budget == 0 && price != 0) {
            memo0.put(key, 0);
            return 0;
        }
        if (price <= budget) {
            // buy
            buyProfit += future[employee - 1] - price;
            buyProfit += dp1(employee, 0, true, budget - price);
        }

        // not buy
        int notBuyProfit = dp1(employee, 0, false, budget);
        int res = Math.max(buyProfit, notBuyProfit);
        memo0.put(key, res);
        return res;
    }

    private int dp1(int boss, int pos, boolean discount, int budget) {
        int key = boss * 10000000 + budget * 10000 + pos * 10 + (discount ? 1 : 0);
        Integer cache = memo1.get(key);
        // if (memo1.containsKey(key))
        // return memo1.get(key);
        if (cache != null) return cache;
        List<Integer> directs = hierarchy.get(boss);
        if (directs == null || pos == directs.size()) {
            memo1.put(key, 0);
            return 0;
        }
        int best = 0, employee = directs.get(pos);
        if (pos == directs.size() - 1) {
            best = dp0(employee, discount, budget);
        } else {
            for (int i = 0; i <= budget; i++) {
                int tmp = dp0(employee, discount, i);
                tmp += dp1(boss, pos + 1, discount, budget - i);
                best = Math.max(best, tmp);
            }
        }
        memo1.put(key, best);
        return best;
    }

    // not my to check later

    private int[][][] dp;
    private int[][] children;
    private int B;

    public int maxProfit_(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.B = budget;

        dp = new int[n][][];

        int[] outdeg = new int[n];
        int[] indeg = new int[n];
        for (int[] h : hierarchy) {
            int u = h[0] - 1, v = h[1] - 1;
            outdeg[u]++;
            indeg[v]++;
        }
        children = new int[n][];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) children[i] = new int[outdeg[i]];
        for (int[] h : hierarchy) {
            int u = h[0] - 1, v = h[1] - 1;
            children[u][idx[u]++] = v;
        }
        int root = 0;
        for (int i = 0; i < n; i++)
            if (indeg[i] == 0) {
                root = i;
                break;
            }

        dfs(root);

        int ans = 0;
        int[][] rootDp = dp[root];
        for (int b = 0; b <= B; b++) {
            if (rootDp[b][0] > ans) ans = rootDp[b][0];
            if (rootDp[b][1] > ans) ans = rootDp[b][1];
        }
        return ans;
    }

    private void dfs(int v) {
        for (int u : children[v]) dfs(u);

        int[] g0 = new int[B + 1];
        int[] g1 = new int[B + 1];
        int[] g2 = new int[B + 1];

        for (int u : children[v]) {
            int[][] cdp = dp[u];

            int[] c0 = new int[B + 1];
            int[] c1 = new int[B + 1];
            int[] c2 = new int[B + 1];
            for (int b = 0; b <= B; b++) {
                int a0 = cdp[b][0], a1 = cdp[b][1], a2 = cdp[b][2];
                c0[b] = a0 > a1 ? a0 : a1;
                c1[b] = a0 > a2 ? a0 : a2;
                int t = a0 > a1 ? a0 : a1;
                c2[b] = t > a2 ? t : a2;
            }

            int[] n0 = new int[B + 1];
            int[] n1 = new int[B + 1];
            int[] n2 = new int[B + 1];

            for (int b = 0; b <= B; b++) {
                if (g0[b] > n0[b]) n0[b] = g0[b];
                if (g1[b] > n1[b]) n1[b] = g1[b];
                if (g2[b] > n2[b]) n2[b] = g2[b];
            }

            for (int cb = 0; cb <= B; cb++) {
                int val0 = c0[cb], val1 = c1[cb], val2 = c2[cb];
                if ((val0 | val1 | val2) == 0) continue;
                int limit = B - cb;
                for (int b = 0; b <= limit; b++) {
                    int nb = b + cb;
                    int v0 = g0[b] + val0;
                    if (v0 > n0[nb]) n0[nb] = v0;
                    int v1 = g1[b] + val1;
                    if (v1 > n1[nb]) n1[nb] = v1;
                    int v2 = g2[b] + val2;
                    if (v2 > n2[nb]) n2[nb] = v2;
                }
            }

            g0 = n0;
            g1 = n1;
            g2 = n2;
            dp[u] = null;
        }

        int[][] cur = new int[B + 1][3];

        int costFull = present[v];
        int costHalf = present[v] / 2;
        int profFull = future[v] - costFull;
        int profHalf = future[v] - costHalf;

        for (int b = 0; b <= B; b++) cur[b][0] = g0[b];
        for (int b = costFull; b <= B; b++) {
            int val = g1[b - costFull] + profFull;
            if (val > cur[b][1]) cur[b][1] = val;
        }
        for (int b = costHalf; b <= B; b++) {
            int val = g2[b - costHalf] + profHalf;
            if (val > cur[b][2]) cur[b][2] = val;
        }

        dp[v] = cur;
    }

    /*
        first impression: some dp + many conidtions
        for any user we have two options: buy and not buy
        we can verify both options
        for any employee we need to split budget across all it's directs
        add memo
    */
}
