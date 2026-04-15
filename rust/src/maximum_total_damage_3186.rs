use crate::common::Solution;

pub fn run_example() {
    // let nums = vec![1, 1, 3, 4];
    let nums = vec![7, 1, 6, 3];

    let result = Solution::maximum_total_damage(nums);
    println!("{result:?}");
}

use std::collections::BTreeMap;
impl Solution {
    pub fn maximum_total_damage(mut power: Vec<i32>) -> i64 {
        let mut count = BTreeMap::new();
        power.sort();
        for value in power {
            *count.entry(value).or_insert(0i64) += 1;
        }

        let values: Vec<i32> = count.keys().copied().collect();
        let mut dp = vec![0i64; values.len() + 1];
        for i in 0..values.len() {
            let compatible_count = values[..i].partition_point(|&x| x <= values[i] - 3);
            dp[i + 1] = dp[i].max(dp[compatible_count] + values[i] as i64 * count[&values[i]]);
        }
        dp[dp.len() - 1]
    }
}
