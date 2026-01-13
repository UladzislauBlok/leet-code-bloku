package org.bloku.task._3453;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Separate Squares I")
@Topics({ARRAY, BINARY_SEARCH})
class Solution {

    public double separateSquares(int[][] squares) {
        double total = 0;
        for (int[] square : squares) total += 1d * square[2] * square[2];
        double low = 0, high = 1e9, mid = -1;
        double threshold = 1e-5;
        while (high - low > threshold) {
            mid = (high + low) / 2;
            if (good(squares, mid, total)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    private boolean good(int[][] squares, double pos, double total) {
        double area = 0;
        for (int[] square : squares) {
            if (square[1] > pos) {
            } else if (square[1] + square[2] <= pos) {
                area += 1d * square[2] * square[2];
            } else {
                double below = pos - square[1];
                area += below * square[2];
            }
        }
        return area >= total / 2;
    }

    /*
        y value are monotonically increasing, so we can use binary search
    */
}
