struct Solution {}

impl Solution {
    pub fn count_permutations(complexity: Vec<i32>) -> i32 {
        const MOD: u64 = 1_000_000_007;
        let n = complexity.len();
        for i in 1..n {
            if complexity[i] <= complexity[0] {
                return 0;
            }
        }
        let mut res: u64 = 1;
        for i in 2..n {
            res = (res * i as u64) % MOD;
        }
        (res % MOD) as i32
    }
}
