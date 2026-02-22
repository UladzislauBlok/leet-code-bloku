use std::cmp::max;

struct Solution {}

impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        let mut prev = -1;
        let mut res = 0;
        for i in 0..32 {
            let mask = 1 << i;
            if (n & mask) == mask {
                if prev != -1 {
                    res = max(res, i - prev);
                }
                prev = i;
            }
        }
        res
    }
}
