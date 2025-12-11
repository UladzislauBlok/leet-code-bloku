struct Solution {}

impl Solution {
    // Dmitry Samoylenko
    pub fn count_covered_buildings(n: i32, b: Vec<Vec<i32>>) -> i32 {
        let (mut min_y, mut max_y) = (vec![100000; n as usize + 1], vec![0; n as usize + 1]);
        let (mut min_x, mut max_x) = (minY.clone(), maxY.clone());
        for b in &b {
            let (x, y) = (b[0] as usize, b[1] as usize);
            minY[x] = minY[x].min(y);
            maxY[x] = maxY[x].max(y);
            minX[y] = minX[y].min(x);
            maxX[y] = maxX[y].max(x);
        }
        b.iter()
            .filter(|&b| {
                let (x, y) = (b[0] as usize, b[1] as usize);
                minX[y] < x && x < maxX[y] && minY[x] < y && y < maxY[x]
            })
            .count() as _
    }

    pub fn count_covered_buildings_my(n: i32, buildings: Vec<Vec<i32>>) -> i32 {
        let n_usize = n as usize;
        let mut max_row = vec![0; n_usize + 1];
        let mut min_row = vec![100001; n_usize + 1];
        let mut max_rol = vec![0; n_usize + 1];
        let mut min_rol = vec![100001; n_usize + 1];
        for p in &buildings {
            let x = p[0] as usize;
            let y = p[1] as usize;
            maxRow[y] = maxRow[y].max(x);
            minRow[y] = minRow[y].min(x);
            maxCol[x] = maxCol[x].max(y);
            minCol[x] = minCol[x].min(y);
        }
        let mut res = 0;
        for p in &buildings {
            let x = p[0] as usize;
            let y = p[1] as usize;
            if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]) {
                res += 1;
            }
        }
        return res;
    }
}
