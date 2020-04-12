cmake_minimum_required(VERSION 3.6)
project(algorithm)

set(CMAKE_CXX_STANDARD 11)

include_directories(common)

set(Boost_USE_STATIC_LIBS OFF)
set(Boost_USE_MULTITHREADED ON)
set(Boost_USE_STATIC_RUNTIME OFF)
find_package(Boost 1.50 REQUIRED COMPONENTS filesystem)
message(STATUS "Boost version: ${Boost_VERSION}")

set(SOURCE_FILES leetcode/Third_maximum_number_414.cpp)
#set(SOURCE_FILES sort/quicksort.cpp sort/insertSort.cpp)
#set(SOURCE_FILES sort/insertSort.cpp)
#set(SOURCE_FILES leetcode/length_of_last_word_58.cpp)
#set(SOURCE_FILES leetcode/Remove_duplicates_from_sorted_list_83.cpp)
# set(SOURCE_FILES leetcode/Balanced_binary_tree_110.cpp leetcode/Binary_tree_level_order_traversal_ii_107.cpp leetcode/Sort_an_array_912.cpp leetcode/Minimum_depth_of_binary_tree_111.cpp leetcode/172.cpp leetcode/Binary_tree_paths_257.cpp)
#set(SOURCE_FILES leetcode/Binary_tree_paths_257.cpp leetcode/Excel_sheet_column_title_168.cpp
#leetcode/Excel_sheet_column_number_171.cpp leetcode/Invert_binary_tree_226.cpp
#leetcode/Lowest_common_ancestor_of_a_binary_search_tree_235.cpp leetcode/Ugly_number_263.cpp
#leetcode/Word_pattern_290.cpp leetcode/Bulls_and_cows_299.cpp leetcode/Range_sum_query_immutable_303.cpp
#leetcode/Sum_of_two_integers_371.cpp leetcode/Ransom_note_383.cpp leetcode/Is_subsequence_392.cpp
#leetcode/Binary_watch_401.cpp leetcode/Third_maximum_number_414.cpp)

add_executable(demo ${SOURCE_FILES})