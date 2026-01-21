struct Solution {}

impl Solution {
    pub fn min_bitwise_array(nums: Vec<i32>) -> Vec<i32> {
        nums.iter()
            .map(|num| {
                let (mut res, mut bit) = (-1, 1);
                while (bit & num) != 0 {
                    res = num - bit;
                    bit = bit << 1;
                }
                res
            })
            .collect()
    }

    // JSusi
    pub fn min_bitwise_array_(mut nums: Vec<i32>) -> Vec<i32> {
        nums.iter_mut().for_each(|num| match num.trailing_ones() {
            0 => *num = -1,
            x => *num ^= 1 << x - 1,
        });
        nums
    }
}
