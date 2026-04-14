use crate::common::Solution;

pub fn run_example() {
    let nums = vec![1, 1, 3, 4];
    let result = Solution::maximum_total_damage(nums);
    println!("{result:?}");
}

impl Solution {
    pub fn maximum_total_damage(power: Vec<i32>) -> i64 {
        if power.is_empty() {
            return 0;
        }

        let mut power = power;
        power.sort_unstable();

        let mut values = Vec::new();
        let mut gains = Vec::new();
    }

