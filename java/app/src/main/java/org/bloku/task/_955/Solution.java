package org.bloku.task._955;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Delete Columns to Make Sorted II")
@Topics({ARRAY, STRING, GREEDY, DFS})
class Solution {
    private final boolean[] remove = new boolean[101];
    private String[] strs;

    public int minDeletionSize(String[] strs) {
        this.strs = strs;
        boolean run = true;
        while (run) run = !dfs(0, 0, strs.length - 1);
        int res = 0;
        for (boolean rm : remove) if (rm) res++;
        return res;
    }

    private boolean dfs(int col, int start, int end) {
        if (col == strs[0].length()) return true;
        if (remove[col]) return dfs(col + 1, start, end);
        char prev = ' ';
        int size = 1;
        for (int i = start; i <= end; i++) {
            char c = strs[i].charAt(col);
            if (prev > c) {
                remove[col] = true;
                return false;
            } else if (prev == c) {
                size++;
            } else {
                if (size > 1 && !dfs(col + 1, i - size, i - 1)) return false;
                prev = c;
                size = 1;
            }
        }
        if (size > 1 && !dfs(col + 1, end - size + 1, end)) return false;
        return true;
    }

    // leetcode
    public int minDeletionSize_(String[] A) {
        int N = A.length;
        int W = A[0].length();
        // cuts[j] is true : we don't need to check any new A[i][j] <= A[i][j+1]
        boolean[] cuts = new boolean[N - 1];

        int ans = 0;
        search:
        for (int j = 0; j < W; ++j) {
            // Evaluate whether we can keep this column
            for (int i = 0; i < N - 1; ++i)
                if (!cuts[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    // Can't keep the column - delete and continue
                    ans++;
                    continue search;
                }

            // Update 'cuts' information
            for (int i = 0; i < N - 1; ++i) if (A[i].charAt(j) < A[i + 1].charAt(j)) cuts[i] = true;
        }

        return ans;
    }
    /*
        We check index by index how we did for yesterday,
        but when we remove, we'll need start from begining
        e.g.,
        x g a
        x f b
        y f a

        x
        x
        2  1  a
        3  2  a
        4  3  a
    */
}
