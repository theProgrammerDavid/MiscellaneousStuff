#include <iostream>
#include <thread>

void hello()
{
    std::cout << "Hello World\n";
}

int main()
{
    std::thread t1(hello);
    t1.join();
    
    return 0;
}