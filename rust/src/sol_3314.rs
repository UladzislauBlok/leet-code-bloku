struct Solution {}

impl Solution {
    pub fn min_bitwise_array(nums: Vec<i32>) -> Vec<i32> {
        nums.into_iter()
            .map(|x| {
                for i in 0..x + 1 {
                    if (i | (i + 1)) == x {
                        return i;
                    }
                }
                -1
            })
            .collect()
    }
}
