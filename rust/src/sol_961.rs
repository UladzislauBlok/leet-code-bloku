struct Solution {}

impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        let mut map = [false; 10001];
        for num in &nums {
            let idx = *num as usize;
            if map[idx] {
                return *num;
            }
            map[idx] = true;
        }
        -1
    }
}
