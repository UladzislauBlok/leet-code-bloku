struct Solution {}

impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        strs.iter()
            .fold((0, vec![0; strs[0].len()]), |(mut res, mut acc), x| {
                let chars = x.as_bytes();
                for (i, c) in chars.iter().enumerate() {
                    if acc[i] == 1 {
                        continue;
                    }
                    if acc[i] > *c {
                        res += 1;
                        acc[i] = 1;
                    } else {
                        acc[i] = *c;
                    }
                }
                (res, acc)
            })
            .0
    }

    // Dmitry Samoylenko
    pub fn min_deletion_size_(s: Vec<String>) -> i32 {
        (0..s[0].len())
            .filter(|&i| (1..s.len()).any(|j| s[j - 1].as_bytes()[i] > s[j].as_bytes()[i]))
            .count() as _
    }
}
