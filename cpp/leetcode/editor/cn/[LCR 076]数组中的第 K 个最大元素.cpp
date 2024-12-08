// LCR 076-xx4gT2

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 103 👎 0


#include "../../comm.h"


using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
private:
    bool is_debug=false;
public:
    int findKthLargest(vector<int>& nums, int k)
    {
        if (nums.size() == 1)
        {
            return nums[0];
        }
        return find_Kth_largest_range(nums, 0, nums.size() - 1, k - 1);
    }

    int find_Kth_largest_range(vector<int>& nums, int left, int right, int k_index)
    {
        if (is_debug)
        {
            cout << "left = " << left << " right = " << right << " k_index = " << k_index << endl;
        }
        if (left >= right)
        {
            return nums[left];
        }
        int pos = get_postion(nums, left, right);
        if (is_debug)
        {
            cout << "pos:" << pos << endl;

        }
        if (pos == k_index)
        {
            return nums[pos];
        }
        if (pos > k_index)
        {
            return find_Kth_largest_range(nums, left, pos - 1, k_index);
        }
        return find_Kth_largest_range(nums, pos + 1, right, k_index);
    }

    int get_postion(vector<int>& nums, int left, int right)
    {
        int l = left + 1;
        int r = right;
        while (true)
        {
            while (l <= right && nums[l] > nums[left])
            {
                l++;
            }
            while (r>=0 && nums[r] < nums[left])
            {
                r--;
            }
            if (l >= r)
            {
                break;
            }
            swap(nums[l], nums[r]);
            l++;
            r--;
        }
        if (is_debug)
        {
            cout << l << ":" << nums[l] << " " << r << ":" << nums[r] << endl;
            for (int i = left; i <= right; i++)
            {
                cout << nums[i] << " ";
            }
            cout << endl;
            cout << left << " " << right << " mid:" << nums[left] << endl;

        }

        swap(nums[r], nums[left]);

        if (is_debug)
        {
            for (int i = left; i <= right; i++)
            {
                cout << nums[i] << " ";
            }
            cout << endl;

        }

        return r;
    }
};

//leetcode submit region end(Prohibit modification and deletion)

int main()
{
    vector<int> vec = {2, 1};
    int k = 1;
    vec = {-1, 2, 0};
    k = 2;

    vec = {3,2,1,5,6,4};
    k = 2;

    vec = {3,3,3,3,3,3,3,3,3};
    k=  1;
    Solution s;

    cout << s.findKthLargest(vec, k) << endl;
}
