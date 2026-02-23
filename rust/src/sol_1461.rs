struct Solution {}

impl Solution {
    pub fn has_all_codes(s: String, k: i32) -> bool {
        let mut curr = 0usize;
        for c in s.bytes().take(k as usize - 1) {
            curr = (curr << 1) + (c - b'0') as usize;
        }

        let mask = 2u32.pow(k as u32) as usize - 1;
        let mut done = vec![false; mask + 1];
        for c in s.into_bytes().into_iter().skip(k as usize - 1) {
            curr = ((curr << 1) + (c - b'0') as usize) & mask;
            done[curr] = true;
        }

        !done.into_iter().any(|x| !x)
    }
}
