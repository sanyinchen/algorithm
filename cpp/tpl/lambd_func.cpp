

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