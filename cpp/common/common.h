//
// Created by sanyinchen on 2025/7/24.
//

#ifndef COMMON_H
#define COMMON_H
#include "TreeNode.h"
#include <vector>
#include <iostream>
#include <unordered_map>
#include <string>
#include <deque>
#include <tuple>
#include <functional>
#include <limits.h>
#include <unordered_set>
#include <memory>
#include <map>
using namespace std;
#endif //COMMON_H
template <typename T, size_t R, size_t C>
std::vector<std::vector<T>> arrayToVector(const T (&arr)[R][C]) {
    std::vector<std::vector<T>> result;
    for (size_t i = 0; i < R; ++i) {
        result.emplace_back(arr[i], arr[i] + C);
    }
    return result;
}
