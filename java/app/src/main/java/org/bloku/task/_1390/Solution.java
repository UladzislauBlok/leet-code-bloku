package org.bloku.task._1390;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

import java.util.HashSet;
import java.util.Set;

@LeetCodeName("Four Divisors")
@Topics({ARRAY, MATH})
class Solution {

    private static final int[] primes =
            new int[] {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167,
                173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263,
                269, 271, 277, 281, 283, 293, 307, 311, 313, 317
            };

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int sum = 0;
            int count = 0;
            for (int d = 1; d * d <= num; d++) {
                if (num % d == 0) {
                    sum += d;
                    count++;
                    if (d * d != num) {
                        sum += num / d;
                        count++;
                    }
                }
                if (count > 4) break;
            }
            // System.out.println(num + " _ " + count);
            if (count == 4) res += sum;
        }
        return res;
    }

    public int sumFourDivisors_(int[] nums) {
        int res = 0;
        for (int num : nums) {
            Set<Integer> divisors = divisors(num);
            if (divisors.size() != 2) continue;
            for (int divisor : divisors) res += divisor;
            res += 1 + num;
        }
        return res;
    }

    private Set<Integer> divisors(int num) {
        Set<Integer> res = new HashSet<>();
        while (true) {
            for (int prime : primes) {
                if (prime * prime > num) {
                    return res;
                }
                if (num % prime == 0) {
                    res.add(prime);
                    res.add(num / prime);
                    num /= prime;
                    break;
                }
            }
        }
    }

    // num can be divided by 1 and itself
    // two more left and both must be prime numbers
    // 47354 -> 1, 47354, 2, 23677
}
