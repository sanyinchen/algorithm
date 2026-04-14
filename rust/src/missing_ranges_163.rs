use crate::common::Solution;

pub fn run_example() {
    let nums = vec![0, 1, 3, 50, 75];
    let lower = 0;
    let upper = 99;
    let result = Solution::find_missing_ranges(nums, lower, upper);
    println!("{result:?}");
}

impl Solution {
    pub fn find_missing_ranges(nums: Vec<i32>, lower: i32, upper: i32) -> Vec<Vec<i32>> {
        let mut res = Vec::new();
        if nums.len() == 0 {
            res.push(vec![lower, upper]);
            return res;
        }
        if nums[0] >= lower && nums[0] - 1 >= lower {
            res.push(vec![lower, nums[0] - 1]);
        }
        for i in 1..nums.len() {
            if nums[i] != nums[i - 1] {
                let start = lower.max(nums[i - 1] + 1);
                let end = nums[i] - 1;
                if start <= upper && start <= end {
                    res.push(vec![start, end]);
                }
            }
        }
        if nums[nums.len() - 1] <= upper && nums[nums.len() - 1] + 1 <= upper {
            res.push(vec![nums[nums.len() - 1] + 1, upper]);
        }
        res
    }
}
