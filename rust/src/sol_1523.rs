struct Solution {}

impl Solution {
    pub fn count_odds(low: i32, high: i32) -> i32 {
        let diff = high - low + 1;
        if (low % 2 == 1 && high % 2 == 1) {
            return diff / 2 + 1;
        }
        diff / 2
    }
}
