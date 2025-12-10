package org.bloku.task._3577;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count the Number of Computer Unlocking Permutations")
@Topics({ARRAY, MATH, COMBINATORICS})
class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int countPermutations(int[] comp) {
        int n = comp.length;
        int first = comp[0];
        for (int i = 1; i < n; i++) {
            if (comp[i] <= first) return 0;
        }

        long fact = 1;
        for (int i = 2; i < n; i++) {
            fact = (fact * i) % MOD;
        }

        return (int) fact;
    }

    public int countPermutations_(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) if (complexity[i] <= complexity[0]) return 0;
        return (int) factorial(n - 1);
    }

    private long factorial(int n) {
        long base = 1;
        while (n > 0) {
            base = (base * n) % MOD;
            n--;
        }
        return base % MOD;
    }
}
