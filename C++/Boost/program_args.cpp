#include <boost/program_options.hpp>
#include <iostream>

namespace opt = boost::program_options;

int main(int argc, char **argv)
{
    opt::options_description desc("All Options");
    desc.add_options()("apples,a", opt::value<int>()->default_value(10), "How many apples do you have ?")("help", "produce help message");

    opt::variables_map vm;
    opt::store(opt::parse_command_line(argc, argv, desc), vm);
    opt::notify(vm);
    if (vm.count("help"))
    {
        std::cout << desc << "\n";
        return 1;
    }

    try
    {
        opt::store(opt::parse_config_file<char>("apples.cfg", desc), vm);
    }
    catch (const opt::reading_file &e)
    {
        std::cout << "Failed to open file 'apples.cfg' :" << e.what();
    }

    opt::notify(vm);
    if (vm.count("name"))
    {
        std::cout << "Hi, " << vm["name"].as<std::string>() << "!\n";
    }

    std::cout << "Fruits count: " << vm["apples"].as<int>() << std::endl;
    return 0;
}