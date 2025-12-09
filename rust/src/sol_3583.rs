struct Solution {}

use std::collections::HashMap;

impl Solution {
    pub fn special_triplets_(nums: Vec<i32>) -> i32 {
        let MOD = 1_000_000_007;
        let n = nums.len();
        let mut map: HashMap<usize, [u32; 2]> = HashMap::with_capacity(n);
        let max = *nums.iter().max().unwrap() as usize;
        let mut f: HashMap<i32, u32> = HashMap::with_capacity(max);
        for (i, num) in nums.iter().enumerate() {
            let entry = map.entry(i).or_insert([0; 2]);
            entry[0] = *f.entry(num * 2).or_insert(0);
            *f.entry(*num).or_insert(0) += 1;
        }
        f.clear();
        for (i, num) in nums.iter().rev().enumerate() {
            let entry = map.entry(n - 1 - i).or_insert([0; 2]);
            entry[1] = *f.entry(num * 2).or_insert(0);
            *f.entry(*num).or_insert(0) += 1;
        }
        let res: u64 = map.iter().map(|x| (x.1[0] * x.1[1]) as u64).sum();
        (res % MOD) as i32
    }

    pub fn special_triplets(nums: Vec<i32>) -> i32 {
        const MOD: i64 = 1000000007;
        const M: usize = 100001;
        let n = nums.len();
        let mut freq: [i32; M] = [0; M];
        let mut prev: [i32; M] = [0; M];
        for i in 0..n {
            freq[nums[i] as usize] += 1;
        }
        let mut cnt = 0 as i64;
        prev[nums[0] as usize] += 1;
        freq[nums[0] as usize] -= 1;
        for i in 1..(n - 1) {
            let x = nums[i] as usize;
            let x2 = x << 1;
            freq[x] -= 1;
            if x2 < M {
                cnt += (prev[x2] as i64) * (freq[x2] as i64);
            }
            prev[x] += 1;
        }
        (cnt % MOD) as i32
    }

    pub fn special_triplets_fold(n: Vec<i32>) -> i32 {
        let mut f = [0i32; 200002];
        let mut c = f.clone();
        n.iter().fold(0, |r, &x| {
            let x = x as usize;
            let rx = c[x >> 1] * ((x & 1) ^ 1) as i32;
            c[x] = (c[x] + f[x << 1]) % 1000000007;
            f[x] += 1;
            (r + rx) % 1000000007
        })
    }
}
