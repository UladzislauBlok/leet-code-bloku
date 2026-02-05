struct Solution {}

impl Solution {
    pub fn construct_transformed_array(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len() as i32;
        nums.iter()
            .enumerate()
            //.map(|(i,num)| nums[((i + *num as usize) % n + n) % n]) issue with type. usize is unsigned
            .map(|(i, &num)| nums[(((i as i32 + num) % n + n) % n) as usize])
            .collect()
    }

    // JSusi
    pub fn construct_transformed_array_(nums: Vec<i32>) -> Vec<i32> {
        (0..nums.len())
            .map(|i| nums[(i as i32 + nums[i]).rem_euclid(nums.len() as i32) as usize])
            .collect()
    }
}
