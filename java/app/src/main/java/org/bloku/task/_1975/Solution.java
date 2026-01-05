package org.bloku.task._1975;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Matrix Sum")
@Topics({ARRAY, GREEDY, MATRIX})
class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    count++;
                    num = -num;
                }
                sum += num;
                min = Math.min(min, num);
            }
        }
        if (count % 2 == 0) return sum;
        return sum - 2 * min;
    }

    /*
        1   1   1   1   -1
        1   1   -1  1   1
        1   1   1   1   1
        1   1   1   1   1
        1   -1  1   1   1

        we can combine ops to achive best result:
        1) when number of negative numbers is even - we can eliminate all of them
        2) when number is odd - only one will left and it will be the smallest one
    */
}
