use std::iter::from_fn;

struct Solution {}

impl Solution {
    // Dmitry Samoylenko
    pub fn add_binary(a: String, b: String) -> String {
        let (mut a, mut b, mut c) = (a.bytes().rev(), b.bytes().rev(), 0);
        from_fn(|| {
            (a.len() > 0 || b.len() > 0 || c > 0).then(|| {
                c += (a.next().unwrap_or(0) & 1) + (b.next().unwrap_or(0) & 1);
                let v = c % 2 + 48;
                c /= 2;
                v as char
            })
        })
        .collect::<Vec<_>>()
        .iter()
        .rev()
        .collect()
    }
}
