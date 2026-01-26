package org.bloku.task._1200;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@LeetCodeName("Minimum Absolute Difference")
@Topics({ARRAY, SORTING})
class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) min = Math.min(min, arr[i] - arr[i - 1]);
        for (int i = 1; i < n; i++)
            if (arr[i] - arr[i - 1] == min) res.add(List.of(arr[i - 1], arr[i]));
        return res;
    }
}
