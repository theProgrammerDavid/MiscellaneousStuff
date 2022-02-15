#include "nums.h"

int sum_range(const int start, const int end)
{
    int sum = 0;
    for (int index = start; index <= end; index++)
    {
        sum += index;
    }
    return sum;
}

int generate(int start, int end, FILE *out)
{
    const std::string name = "sum_in_range";
    // char param[50];
    // sprintf(param, "%d %d", start, end);
    const std::string params = start + " " + end;
    // char *values = {name, param};
    
}