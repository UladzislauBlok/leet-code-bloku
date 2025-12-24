struct Solution {}

impl Solution {
    pub fn minimum_boxes(apple: Vec<i32>, mut capacity: Vec<i32>) -> i32 {
        let apple_sum: i32 = apple.into_iter().sum();
        let mut capacity_sum = 0;
        capacity.sort();
        for (i, num) in capacity.into_iter().rev().enumerate() {
            capacity_sum += num;
            if capacity_sum >= apple_sum {
                return i as i32 + 1;
            }
        }
        -1
    }

    // Dmitry Samoylenko
    pub fn minimum_boxes_(a: Vec<i32>, c: Vec<i32>) -> i32 {
        let mut s = a.iter().sum::<i32>();
        let mut f = [0; 51];
        for c in c {
            f[c as usize] += 1
        }
        let mut j = 50;
        (1..51)
            .find(|_| {
                while f[j] < 1 {
                    j -= 1
                }
                s -= j as i32;
                f[j] -= 1;
                s <= 0
            })
            .unwrap() as _
    }
}
