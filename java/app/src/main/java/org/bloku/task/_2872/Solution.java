package org.bloku.task._2872;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.List;

@LeetCodeName("Maximum Number of K-Divisible Components")
@Topics({})
class Solution {

    private List<Integer>[] leafs;
    private int[] values;
    private int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n == 1) return 1;
        if (n == 2) {
            return values[0] % k == 0 ? 2 : 1;
        }
        this.leafs = new List[n];
        this.values = values;
        for (int i = 0; i < n; i++) {
            leafs[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            leafs[edge[0]].add(edge[1]);
            leafs[edge[1]].add(edge[0]);
        }
        dfs(0, k, -1);
        return count;
    }

    private long dfs(int curr, int k, int prev) {
        long sum = values[curr];
        for (int child : leafs[curr]) {
            if (child != prev) {
                sum += dfs(child, k, curr);
            }
        }
        count += (sum % k == 0 ? 1 : 0);
        return sum % k == 0 ? 0 : sum;
    }

    /*
        It's about plaing with subtries
        We start from smallest one (from the bottom)
        if tree is divisible by k, we increasee result by one,
        and won't reuse this tree.
    */
}
