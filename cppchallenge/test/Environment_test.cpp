#include <gmock/gmock.h>
#include <gtest/gtest.h>
#include "../src/Environment.hpp"
#include <string>

using std::string;
using ::testing::Return;

class MockSource : public ISource {
    public:
        MOCK_METHOD(string, get, (string), (const, override));
};

TEST(Environment, GetVariable) {
    MockSource mockSource;
    EXPECT_CALL(mockSource, get("MY_ENV_VARIABLE")).Times(1).WillOnce(Return("WINDOWS"));
    Variables *sut = new Variables(&mockSource);
    std::string expected = "WINDOWS";
    std::string actual = sut->get("MY_ENV_VARIABLE");
    EXPECT_EQ(expected, actual);
}

TEST(Environment, GetOSVariable) {
    OSSource source;
    Variables *sut = new Variables(&source);
    std::string expected = "linux";
    std::string actual = sut->get("GOOS");
    EXPECT_EQ(expected, actual);
}