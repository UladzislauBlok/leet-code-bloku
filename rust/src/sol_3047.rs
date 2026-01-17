use std::cmp::{max, min};

struct Solution {}

impl Solution {
    pub fn largest_square_area(bottom_left: Vec<Vec<i32>>, top_right: Vec<Vec<i32>>) -> i64 {
        let n = bottom_left.len();
        let mut max_side = 0;

        for i in 0..n {
            for j in i + 1..n {
                let w = min(top_right[i][0], top_right[j][0])
                    - max(bottom_left[i][0], bottom_left[j][0]);
                let h = min(top_right[i][1], top_right[j][1])
                    - max(bottom_left[i][1], bottom_left[j][1]);

                max_side = max(max_side, min(w, h));
            }
        }

        (max_side as i64) * (max_side as i64)
    }

    // JSusi
    pub fn largest_square_area_(bottom_left: Vec<Vec<i32>>, top_right: Vec<Vec<i32>>) -> i64 {
        bottom_left[..bottom_left.len() - 1]
            .iter()
            .zip(&top_right)
            .enumerate()
            .flat_map(|(i, (ab, at))| {
                bottom_left[i + 1..]
                    .iter()
                    .zip(&top_right[i + 1..])
                    .map(|(bb, bt)| {
                        let xo = bt[0].min(at[0]) - bb[0].max(ab[0]);
                        let yo = bt[1].min(at[1]) - bb[1].max(ab[1]);
                        i64::from(xo.min(yo).max(0)).pow(2)
                    })
            })
            .max()
            .unwrap_or_default()
    }
}
