struct Solution {}

impl Solution {
    pub fn count_prime_set_bits(left: i32, right: i32) -> i32 {
        let mask = [
            false, false, true, true, false, true, false, true, false, false, false, true, false,
            true, false, false, false, true, false, true, false,
        ];
        let mut count = 0;
        for i in left..right + 1 {
            count += mask[i.count_ones() as usize] as i32;
        }
        count
    }
}
