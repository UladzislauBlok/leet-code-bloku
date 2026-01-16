package org.bloku.task._2975;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@LeetCodeName("Maximum Square Area by Removing Fences From a Field")
@Topics({ARRAY, HASH_TABLE, ENUMERATION})
class Solution {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> set = new HashSet<>();
        long max = -1;
        for (int i = 0; i < hFences.length; i++) {
            set.add(hFences[i] - 1);
            set.add(m - hFences[i]);
        }
        set.add(m - 1);
        for (int i = 0; i < hFences.length - 1; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                set.add(hFences[j] - hFences[i]);
            }
        }
        for (int i = 0; i < vFences.length; i++) {
            int size = vFences[i] - 1;
            if (set.contains(size)) max = Math.max(max, 1L * size * size);
            size = n - vFences[i];
            if (set.contains(size)) max = Math.max(max, 1L * size * size);
        }
        if (set.contains(n - 1)) max = Math.max(max, 1L * (n - 1) * (n - 1));
        for (int i = 0; i < vFences.length - 1; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                int size = vFences[j] - vFences[i];
                if (set.contains(size)) max = Math.max(max, 1L * size * size);
            }
        }
        return (int) (max % 1000000007L);
    }
}
