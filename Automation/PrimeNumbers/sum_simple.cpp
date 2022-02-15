#include "nums.h"

int main(int argc, char **argv)
{
    if (argc < 3)
    {
        std::cout << "Argument should be provided as \n"
                     "./a.out start_index end_index";
    }
    std::cout << sum_range(std::atoi(argv[1]), std::atoi(argv[2]));
}