cmake_minimum_required(VERSION 3.16)
project(algorithm)

set(CMAKE_CXX_STANDARD 11)

include_directories(common)

#set(Boost_USE_STATIC_LIBS OFF)
#set(Boost_USE_MULTITHREADED ON)
#set(Boost_USE_STATIC_RUNTIME OFF)
#find_package(Boost 1.50 REQUIRED COMPONENTS filesystem)
#message(STATUS "Boost version: ${Boost_VERSION}")
file(COPY ${CMAKE_SOURCE_DIR}/codeforces/cf_input.txt DESTINATION ${CMAKE_BINARY_DIR})

set(NIUKE_INPUT ${CMAKE_SOURCE_DIR}/niuke/niuke_input.txt)
set(NIUKE_OUTPUT ${CMAKE_BINARY_DIR}/niuke_input.txt)
# 复制文件，如果源文件有更新，就重新执行
add_custom_command(
        OUTPUT ${NIUKE_OUTPUT}
        COMMAND ${CMAKE_COMMAND} -E copy_if_different ${NIUKE_INPUT} ${NIUKE_OUTPUT}
        DEPENDS ${NIUKE_INPUT}
        COMMENT "Copying updated niuke_input.txt to build directory"
)

add_custom_target(niuke_input ALL DEPENDS ${NIUKE_OUTPUT})


#set(SOURCE_FILES codeforces/1446_Knapsack.cpp)


set(CMAKE_CXX_STANDARD 20)
file(GLOB SOURCE_FILES "${CMAKE_CURRENT_SOURCE_DIR}/leetcode/editor/cn/*.cpp")
#set(SOURCE_FILES leetcode/460_3_minJumps.cpp)
list(APPEND SOURCE_FILES leetcode/0_common.cpp)

#set(SOURCE_FILES niuke/296753.cpp)

#list(APPEND SOURCE_FILES leetcode/527_wordsAbbreviation.cpp)


# set(SOURCE_FILES leetcode/Third_maximum_number_414.cpp leetcode/Univalued_binary_tree_965.cpp
# leetcode/Arranging_coins_441.cpp leetcode/Binary_tree_right_side_view_199.cpp leetcode/Longest_palindrome_409.cpp)
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
add_dependencies(demo niuke_input)