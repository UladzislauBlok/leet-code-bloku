struct Solution {}

impl Solution {
    pub fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
        for num in digits.iter_mut().rev() {
            if *num == 9 {
                *num = 0;
            } else {
                *num += 1;
                return digits;
            }
        }
        digits.push(1);
        digits.into_iter().rev().collect()
    }
}
