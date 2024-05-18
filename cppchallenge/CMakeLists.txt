cmake_minimum_required(VERSION 3.14)

project(cppchallenge)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

file(GLOB SOURCES "src/*.cpp")
add_executable(main ${SOURCES})
target_include_directories(main PUBLIC src)

include(FetchContent)
FetchContent_Declare(
  googletest
  URL https://github.com/google/googletest/archive/03597a01ee50ed33e9dfd640b249b4be3799d395.zip
)

FetchContent_MakeAvailable(googletest)

enable_testing()

file(GLOB TEST_SOURCES "test/*.cpp")

add_executable(
  SuiteTest
  ${TEST_SOURCES}
  src/Environment.cpp
)

target_link_libraries(
  SuiteTest
  PRIVATE
  GTest::gtest_main
  GTest::gmock_main
)
target_include_directories(SuiteTest PUBLIC src)

set(CMAKE_GTEST_DISCOVER_TESTS_DISCOVERY_MODE PRE_TEST)
include(GoogleTest)
gtest_discover_tests(SuiteTest)