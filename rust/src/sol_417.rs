struct Solution {}

impl Solution {
    pub fn pacific_atlantic(h: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let (m, n) = (h.len(), h[0].len());
        let mut q = Vec::with_capacity(m * n);
        let (mut v, mut res) = (vec![0u8; m * n], vec![]);
        for i in 0..m {
            q.push((i, 0, 1));
            q.push((i, n - 1, 2))
        }
        for i in 0..n {
            q.push((0, i, 1));
            q.push((m - 1, i, 2))
        }
        while let Some((y, x, b)) = q.pop() {
            if v[y * n + x] & b < 1 {
                v[y * n + x] |= b;
                if v[y * n + x] > 2 {
                    res.push(vec![y as i32, x as i32])
                }
                for (u, r) in [(y - 1, x), (y + 1, x), (y, x - 1), (y, x + 1)] {
                    if u < m && r < n && h[u][r] >= h[y][x] {
                        q.push((u, r, b))
                    }
                }
            }
        }
        res
    }

    pub fn pacific_atlantic_my(heights: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let (n, m) = (heights.len(), heights[0].len());
        let mut pacific = [[false; 200]; 200];
        let mut atlantic = [[false; 200]; 200];
        for i in 0..n {
            Self::dfs(i, 0, n, m, &mut pacific, &heights);
        }
        for i in 0..m {
            Self::dfs(0, i, n, m, &mut pacific, &heights);
        }
        for i in 0..n {
            Self::dfs(i, m - 1, n, m, &mut atlantic, &heights);
        }
        for i in 0..m {
            Self::dfs(n - 1, i, n, m, &mut atlantic, &heights);
        }
        let mut res: Vec<Vec<i32>> = vec![];
        for i in 0..n {
            for j in 0..m {
                if pacific[i][j] && atlantic[i][j] {
                    res.push(vec![i as i32, j as i32]);
                }
            }
        }
        res
    }

    fn dfs(
        i: usize,
        j: usize,
        n: usize,
        m: usize,
        visited: &mut [[bool; 200]; 200],
        heights: &Vec<Vec<i32>>,
    ) {
        if visited[i][j] {
            return ();
        }
        visited[i][j] = true;
        let directions: [i32; 5] = [-1, 0, 1, 0, -1];
        for k in 0..4 {
            let a = i as i32 + directions[k];
            let b = j as i32 + directions[k + 1];
            if a < 0 || b < 0 || a == n as i32 || b == m as i32 {
                continue;
            }
            if heights[a as usize][b as usize] < heights[i][j] {
                continue;
            }
            Self::dfs(a as usize, b as usize, n, m, visited, heights);
        }
    }
}
