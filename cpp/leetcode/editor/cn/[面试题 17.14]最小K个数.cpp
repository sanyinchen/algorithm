//面试题 17.14-smallest-k-lcci


//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 236 👎 0


#include"../../comm.h"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> smallestK(vector<int>& arr, int k) {
        smallest_k_elements(arr, 0, arr.size() - 1, k);
        return vector<int>(arr.begin(), arr.begin() + k);
    }

    void smallest_k_elements(vector<int>& nums, int l, int r, int k) {
        if (l >= r) return;
        if (l >= k) return;
        int index = partition(nums, l, r);
        if (index == k - 1) return;
        cout << l << " " << r << endl;
        if (index < k) {
            smallest_k_elements(nums, index + 1, r, k);
        }
        else {
            smallest_k_elements(nums, l, index - 1, k);
        }
    }

    int partition(vector<int>& nums, int left, int right) {
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }
            swap(nums[lt], nums[gt]);
            lt++;
            gt--;
        }
        swap(nums[left], nums[gt]);
        return gt;
    }
};

//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;
    vector<int> arr = {1, 3, 5, 7, 2, 4, 6, 8};
    vector<int> res = s.smallestK(arr, 4);
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
}
