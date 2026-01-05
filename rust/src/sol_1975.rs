struct Solution {}

impl Solution {
    pub fn max_matrix_sum(matrix: Vec<Vec<i32>>) -> i64 {
        let smc = matrix
            .into_iter() // sum min count
            .flat_map(|row| row.into_iter())
            .fold((0, i32::MAX, 0), |(s, m, mut c), mut x| {
                c += (x < 0) as i32;
                x = x.abs();
                (s + x as i64, m.min(x), c)
            });
        smc.0 - (2 * smc.1 * (smc.2 & 1)) as i64
    }
}
