struct Solution {}

impl Solution {
    pub fn maximum_happiness_sum(mut happiness: Vec<i32>, k: i32) -> i64 {
        happiness.sort();
        let n = happiness.len();
        happiness
            .into_iter()
            .skip(n - k as usize)
            .rev()
            .enumerate()
            .fold(0, |acc, (i, val)| acc + (val - i as i32).max(0) as i64)
    }

    // Dmitry Samoylenko
    pub fn maximum_happiness_sum_(mut h: Vec<i32>, k: i32) -> i64 {
        h.sort_unstable_by(|a, b| b.cmp(a));
        h.iter().zip(0..k).map(|(h, i)| 0.max(h - i) as i64).sum()
    }
}
