package org.bloku.task._3623;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.HashMap;
import java.util.Map;

@LeetCodeName("Count Number of Trapezoids I")
@Topics({ARRAY, HASH_TABLE, MATH})
class Solution {

    private final int MOD = (int) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        int res = 0;
        Map<Integer, Integer> lines = new HashMap<>();
        for (int[] point : points) lines.merge(point[1], 1, Integer::sum);
        long prev = 0;
        for (Map.Entry<Integer, Integer> line : lines.entrySet()) {
            if (line.getValue() == 1) {
                continue;
            }
            int currLine = line.getValue();
            long currLineSum = ((1L * (currLine - 1) * currLine) / 2);
            res = (int) ((res + prev * currLineSum) % MOD);
            prev += currLineSum;
        }
        return res;
    }

    /*
        We're searching horizontal lines, so let's combine input by lines (map)
        It's about calculating (n-1 * n) for every line
    */ }
