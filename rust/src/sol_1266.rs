struct Solution {}

impl Solution {
    pub fn min_time_to_visit_all_points(p: Vec<Vec<i32>>) -> i32 {
        (0..p.len() - 1).fold(0, |acc, i| {
            acc + (p[i][0] - p[i + 1][0])
                .abs()
                .max((p[i][1] - p[i + 1][1]).abs())
        })
    }

    // Dmitry Samoylenko
    pub fn min_time_to_visit_all_points_(p: Vec<Vec<i32>>) -> i32 {
        p.iter()
            .zip(&p[1..])
            .map(|(a, b)| (a[0] - b[0]).abs().max((a[1] - b[1]).abs()))
            .sum()
    }

    pub fn min_time_to_visit_all_points__(points: Vec<Vec<i32>>) -> i32 {
        let mut res = 0;
        for window in points.windows(2) {
            res += (window[0][0] - window[1][0])
                .abs()
                .max((window[0][1] - window[1][1]).abs());
        }
        res
    }
}
