#include <iostream>
#include <boost/any.hpp>
#include <vector>
#include <string>

int main()
{
    std::vector<boost::any> vec;
    vec.push_back(10);
    vec.push_back("Hello");
    vec.push_back(std::string("World"));

    std::string &s = boost::any_cast<std::string &>(vec.back());
    s += " World";
    std::cout << s << "\n";
}

/**
 * if any_cast<typename T>(arg) cannot cast, it willl throw an exception
 * of type boost::bad_any_cast exception
 * */
