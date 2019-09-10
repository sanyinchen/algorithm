cmake_minimum_required(VERSION 3.6)
project(algorithm)

set(CMAKE_CXX_STANDARD 11)

#set(SOURCE_FILES sort/quicksort.cpp sort/insertSort.cpp)

#set(SOURCE_FILES sort/insertSort.cpp)

set(SOURCE_FILES aizu_judge/ALDS1_2_B_Selection_Sort.cpp)
add_executable(demo ${SOURCE_FILES})