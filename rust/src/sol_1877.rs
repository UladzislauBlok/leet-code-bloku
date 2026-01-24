struct Solution {}

impl Solution {
    pub fn min_pair_sum(mut nums: Vec<i32>) -> i32 {
        nums.sort_unstable();
        nums[..nums.len() / 2]
            .iter()
            .zip(nums[(nums.len() / 2)..].iter().rev())
            .fold(0, |acc, (l, r)| acc.max(l + r))
    }
}
