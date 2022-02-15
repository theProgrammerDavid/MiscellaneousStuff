#include "nums.h"

int main(int argc, char **argv)
{
    int start, end;

    for (int i = 0; i < 5; i++)
    {
        std::cin >> start;
        std::cin >> end;

        std::cout << sum_range(start, end) << "\n";
    }
}