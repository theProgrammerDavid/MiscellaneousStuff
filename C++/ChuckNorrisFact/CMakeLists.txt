cmake_minimum_required(VERSION 3.10)

project(ChuckNorris)
set(CMAKE_CXX_STANDARD 11)

include(${CMAKE_SOURCE_DIR}/thirdparty/conanbuildinfo.cmake)
conan_basic_setup(TARGETS)

add_library(chucknorris 
include/ChuckNorris.hpp 
src/ChuckNorris.cpp
src/c_wrapper.cpp
)

include_directories("include")
target_include_directories(chucknorris PUBLIC ${CONAN_INCLUDE_DIRS})

add_executable(cpp_demo src/main.cpp)

add_executable(c_demo src/main.c)

target_link_libraries(chucknorris CONAN_PKG::sqlite3)

target_link_libraries(c_demo chucknorris)

target_link_libraries(cpp_demo chucknorris)
