package org.bloku.task._1877;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.Arrays;

@LeetCodeName("Minimize Maximum Pair Sum in Array")
@Topics({ARRAY, TWO_POINTERS, GREEDY, SORTING})
class Solution {

    public int minPairSum(int[] nums) {
        int[] freq = new int[100001]; // n <= 10^5
        int right = 0, left = 100001;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
            freq[num]++;
        }
        int res = 0;
        while (left < right) {
            while (freq[left] == 0 && left < right) left++;
            while (freq[right] == 0 && left < right) right--;
            if (left > right || freq[left] == 0) break;
            res = Math.max(res, left + right);
            freq[left]--;
            freq[right]--;
        }
        return res;
    }

    public int minPairSum_(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) res = Math.max(res, nums[left++] + nums[right--]);
        return res;
    }
}
