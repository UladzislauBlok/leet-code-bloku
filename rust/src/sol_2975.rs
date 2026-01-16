use std::collections::HashSet;

struct Solution {}

impl Solution {
    pub fn maximize_square_area_(
        m: i32,
        n: i32,
        mut h_fences: Vec<i32>,
        mut v_fences: Vec<i32>,
    ) -> i32 {
        h_fences.sort_unstable();
        v_fences.sort_unstable();
        let mut set: HashSet<i32> = HashSet::new();
        let mut max = -1;
        for h in h_fences.iter() {
            set.insert(h - 1);
            set.insert(m - h);
        }
        set.insert(m - 1);
        for i in 0..h_fences.len() - 1 {
            for j in i + 1..h_fences.len() {
                set.insert(h_fences[j] - h_fences[i]);
            }
        }
        for v in v_fences.iter() {
            let size = v - 1;
            if set.contains(&size) {
                max = max.max(size);
            }
            let size = n - v;
            if set.contains(&size) {
                max = max.max(size);
            }
        }
        let size = n - 1;
        if set.contains(&size) {
            max = max.max(size);
        }
        for i in 0..v_fences.len() - 1 {
            for j in i + 1..v_fences.len() {
                let size = v_fences[j] - v_fences[i];
                if set.contains(&size) {
                    max = max.max(size);
                }
            }
        }
        if max == -1 {
            return -1;
        }
        let max64 = max as i64;
        (max64 * max64 % 1000000007 as i64) as _
    }

    // JSusi
    pub fn maximize_square_area(m: i32, n: i32, h_fences: Vec<i32>, v_fences: Vec<i32>) -> i32 {
        let into_set = |mut f: Vec<_>, m: _| -> std::collections::BinaryHeap<_> {
            f.sort_unstable();
            std::iter::once(&1)
                .chain(&f)
                .enumerate()
                .flat_map(|(i, l)| f[i..].iter().chain([&m]).map(move |r| r - l))
                .collect()
        };
        let mut h = into_set(h_fences, m);
        let mut v = into_set(v_fences, n);
        while let (Some(hv), Some(vv)) = (h.peek(), v.peek()) {
            match hv.cmp(vv) {
                std::cmp::Ordering::Less => {
                    v.pop();
                }
                std::cmp::Ordering::Greater => {
                    h.pop();
                }
                std::cmp::Ordering::Equal => return (i64::from(*hv).pow(2) % 1_000_000_007) as _,
            }
        }
        -1
    }
}
