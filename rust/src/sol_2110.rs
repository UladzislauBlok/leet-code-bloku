struct Solution {}

impl Solution {
    pub fn get_descent_periods(p: Vec<i32>) -> i64 {
        (0..p.len())
            .fold((0, 0), |(cnt, res), i| {
                let c = 1 + if i > 0 && p[i] == p[i - 1] - 1 {
                    cnt
                } else {
                    0
                };
                (c, res + c)
            })
            .1
    }

    pub fn get_descent_periods_branchless(prices: Vec<i32>) -> i64 {
        let mut sum = 0 as i64;
        let mut des = 0 as i64;
        let mut prev = -1;
        for x in prices {
            let is_minus_1 = (x + 1 == prev) as i64;
            let mask = -is_minus_1;
            sum += (!mask) & des * (des + 1) / 2;
            des = (mask & des) + 1;
            prev = x;
        }
        sum += des * (des + 1) / 2;
        sum
    }

    pub fn get_descent_periods_(prices: Vec<i32>) -> i64 {
        let (mut prev, mut window, mut res): (i32, i64, i64) = (-1, 0, 0);
        for num in prices.iter() {
            if prev - 1 == *num {
                window += 1;
            } else {
                window = 1;
            }
            res += window;
            prev = *num;
        }
        res
    }
}
