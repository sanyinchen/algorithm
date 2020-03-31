cmake_minimum_required(VERSION 3.6)
project(algorithm)

set(CMAKE_CXX_STANDARD 11)

include_directories(common)

#set(SOURCE_FILES sort/quicksort.cpp sort/insertSort.cpp)
#set(SOURCE_FILES sort/insertSort.cpp)
#set(SOURCE_FILES leetcode/length_of_last_word_58.cpp)
#set(SOURCE_FILES leetcode/Remove_duplicates_from_sorted_list_83.cpp)
set(SOURCE_FILES leetcode/Balanced_binary_tree_110.cpp leetcode/Binary_tree_level_order_traversal_ii_107.cpp leetcode/Sort_an_array_912.cpp)


add_executable(demo ${SOURCE_FILES})