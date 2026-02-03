struct Solution {}

impl Solution {
    pub fn is_trionic(nums: Vec<i32>) -> bool {
        let (mut i, n) = (1, nums.len());
        while i < n && nums[i] > nums[i - 1] {
            i += 1;
        }
        if i == n || i == 1 {
            return false;
        }
        while i < n && nums[i] < nums[i - 1] {
            i += 1;
        }
        if i == n {
            return false;
        }
        while i < n && nums[i] > nums[i - 1] {
            i += 1;
        }
        if i != n {
            return false;
        }
        true
    }

    // Dmitry Samoylenko 0_0
    pub fn is_trionic_(n: Vec<i32>) -> bool {
        n.windows(2)
            .map(|w| w[1].cmp(&w[0]) as i8)
            .collect::<Vec<_>>()
            .chunk_by(i8::eq)
            .map(|c| c[0])
            .eq([1, -1, 1])
    }
}
