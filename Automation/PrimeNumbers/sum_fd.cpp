#include "nums.h"

int main(int argc, char *argv[])
{
    FILE *input = fopen(argv[1], "r");
    int start, end;
    fscanf(input, "%d", &start);
    fscanf(input, "%d", &end);
    fclose(input);

    const int ans = sum_range(start, end);

    FILE *output = fopen(argv[2], "w");
    fprintf(output, "Output is %d", ans);
    fclose(output);
}