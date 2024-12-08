// 315-count-of-smaller-numbers-after-self

//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1107 👎 0


#include "../../comm.h"


using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> counts(n, 0);  // 结果数组
        vector<int> indexes(n);   // 索引数组
        iota(indexes.begin(), indexes.end(), 0);  // 初始化索引数组为 [0, 1, 2, ..., n-1]

        // 归并排序
        function<void(int, int)> mergeSort = [&](int left, int right) {
            if (left >= right) return;

            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            vector<int> tempIndexes(right - left + 1);
            int i = left, j = mid + 1, k = 0;

            while (i <= mid && j <= right) {
                if (nums[indexes[i]] <= nums[indexes[j]]) {
                    counts[indexes[i]] += (j - mid - 1);  // 统计右侧小于当前元素的个数
                    tempIndexes[k++] = indexes[i++];
                } else {
                    tempIndexes[k++] = indexes[j++];
                }
            }

            while (i <= mid) {
                counts[indexes[i]] += (j - mid - 1);
                tempIndexes[k++] = indexes[i++];
            }

            while (j <= right) {
                tempIndexes[k++] = indexes[j++];
            }

            for (int p = 0; p < tempIndexes.size(); ++p) {
                indexes[left + p] = tempIndexes[p];
            }
        };

        mergeSort(0, n - 1);
        return counts;
    }


};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    vector<int> vec= {};
    Solution s;
}