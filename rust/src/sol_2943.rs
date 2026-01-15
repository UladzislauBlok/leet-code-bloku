struct Solution {}

impl Solution {
    pub fn maximize_square_hole_area(
        n: i32,
        m: i32,
        mut h_bars: Vec<i32>,
        mut v_bars: Vec<i32>,
    ) -> i32 {
        h_bars.sort();
        v_bars.sort();
        let wh = h_bars
            .iter()
            .fold((1, 1, -2), |acc, x| {
                let w = if acc.2 + 1 == *x { acc.1 + 1 } else { 1 };
                (acc.0.max(w), w, *x)
            })
            .0;
        let wv = v_bars
            .iter()
            .fold((1, 1, -2), |acc, x| {
                let w = if acc.2 + 1 == *x { acc.1 + 1 } else { 1 };
                (acc.0.max(w), w, *x)
            })
            .0;
        let size = wh.min(wv) + 1;
        size * size
    }

    // JSusi
    pub fn maximize_square_hole_area_(n: i32, m: i32, h_bars: Vec<i32>, v_bars: Vec<i32>) -> i32 {
        [h_bars, v_bars]
            .into_iter()
            .filter_map(|mut bars| {
                bars.sort_unstable();
                bars.chunk_by(|a, b| b - a == 1)
                    .map(|c| c.len() as i32 + 1)
                    .max()
            })
            .min()
            .unwrap()
            .pow(2)
    }
}
