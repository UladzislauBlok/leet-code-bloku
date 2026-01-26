struct Solution {}

impl Solution {
    pub fn minimum_abs_difference_(mut arr: Vec<i32>) -> Vec<Vec<i32>> {
        arr.sort_unstable();
        arr.iter()
            .zip(arr[1..].iter())
            .fold((Vec::new(), i32::MAX), |mut acc, (a, b)| {
                let mut min: i32 = acc.1;
                if b - a < min {
                    min = b - a;
                    acc.0.clear();
                }
                if b - a == min {
                    acc.0.push(vec![*a, *b]);
                }
                (acc.0, min)
            })
            .0
    }

    pub fn minimum_abs_difference(mut arr: Vec<i32>) -> Vec<Vec<i32>> {
        arr.sort_unstable();
        let min_diff = arr
            .windows(2)
            .map(|w| w[1] - w[0])
            .min()
            .unwrap_or(i32::MAX);

        arr.windows(2)
            .filter(|w| w[1] - w[0] == min_diff)
            .map(|w| vec![w[0], w[1]])
            .collect()
    }
}
