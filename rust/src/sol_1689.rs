struct Solution {}

impl Solution {
    pub fn min_partitions(n: String) -> i32 {
        n.bytes().max().unwrap_or(0) as i32 - 48
    }
}
