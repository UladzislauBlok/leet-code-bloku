package org.bloku.task._3047;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Largest Area of Square Inside Two Rectangles")
@Topics({ARRAY, MATH})
class Solution {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            int[] bottomLeft1 = bottomLeft[i];
            int[] topRight1 = topRight[i];
            for (int j = i + 1; j < n; j++) {
                int[] bottomLeft2 = bottomLeft[j];
                int[] topRight2 = topRight[j];
                int h =
                        Math.min(topRight1[1], topRight2[1])
                                - Math.max(bottomLeft1[1], bottomLeft2[1]);
                int w =
                        Math.min(topRight1[0], topRight2[0])
                                - Math.max(bottomLeft1[0], bottomLeft2[0]);
                int size = Math.min(h, w);
                max = Math.max(max, size);
            }
        }
        return max * max;
    }
}
