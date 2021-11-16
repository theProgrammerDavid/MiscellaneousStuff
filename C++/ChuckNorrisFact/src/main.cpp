#include "ChuckNorris.hpp"
#include <iostream>

int main()
{
    ChuckNorris cn;
    std::string fact = cn.getFact();
    std::cout << fact << std::endl;

    return 0;
}