struct Solution {}

impl Solution {
    // Dmitry Samoylenko
    pub fn count_covered_buildings(n: i32, b: Vec<Vec<i32>>) -> i32 {
        let (mut min_y, mut max_y) = (vec![100000; n as usize + 1], vec![0; n as usize + 1]);
        let (mut min_x, mut max_x) = (min_y.clone(), max_y.clone());
        for b in &b {
            let (x, y) = (b[0] as usize, b[1] as usize);
            min_y[x] = min_y[x].min(y);
            max_y[x] = max_y[x].max(y);
            min_x[y] = min_x[y].min(x);
            max_x[y] = max_x[y].max(x);
        }
        b.iter()
            .filter(|&b| {
                let (x, y) = (b[0] as usize, b[1] as usize);
                min_x[y] < x && x < max_x[y] && min_y[x] < y && y < max_y[x]
            })
            .count() as _
    }

    pub fn count_covered_buildings_my(n: i32, buildings: Vec<Vec<i32>>) -> i32 {
        let n_usize = n as usize;
        let mut max_row = vec![0; n_usize + 1];
        let mut min_row = vec![100001; n_usize + 1];
        let mut max_col = vec![0; n_usize + 1];
        let mut min_col = vec![100001; n_usize + 1];
        for p in &buildings {
            let x = p[0] as usize;
            let y = p[1] as usize;
            max_row[y] = max_row[y].max(x);
            min_row[y] = min_row[y].min(x);
            max_col[x] = max_col[x].max(y);
            min_col[x] = min_col[x].min(y);
        }
        let mut res = 0;
        for p in &buildings {
            let x = p[0] as usize;
            let y = p[1] as usize;
            if (x > min_row[y] && x < max_row[y] && y > min_col[x] && y < max_col[x]) {
                res += 1;
            }
        }
        return res;
    }
}
