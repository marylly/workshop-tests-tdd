#include <Environment.hpp>
#include <string>

Variables::Variables(ISource* source): msource(source) {}

std::string Variables::get(std::string name) {
    return msource->get(name);
}

std::string OSSource::get(std::string name) const {
    const char * variable = name.c_str();
    return std::string(getenv(variable));
}