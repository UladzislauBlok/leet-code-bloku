struct Solution {}

impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        let r#mod = 1e9 as usize + 7;
        (1..n + 1)
            .fold((0usize, 1), |mut acc, x| {
                acc.1 += (x & (1 << acc.1)).min(1);
                ((acc.0 << acc.1) % r#mod + x as usize, acc.1)
            })
            .0 as _
    }
}
