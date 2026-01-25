struct Solution {}

impl Solution {
    pub fn minimum_difference_(mut nums: Vec<i32>, k: i32) -> i32 {
        nums.sort_unstable();
        let mut res = i32::MAX;
        let (mut front, mut back) = (k - 1, 0);
        while front < nums.len() as i32 {
            res = std::cmp::min(res, nums[front as usize] - nums[back as usize]);
            front += 1;
            back += 1;
        }
        res
    }

    pub fn minimum_difference(mut nums: Vec<i32>, k: i32) -> i32 {
        nums.sort_unstable();
        nums.iter()
            .zip(nums.iter().skip(k as usize - 1))
            .map(|(l, r)| r - l)
            .min()
            .unwrap_or(0)
    }
}
