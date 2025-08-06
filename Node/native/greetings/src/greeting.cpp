#include <iostream>
#include <string>

#include "greeting.h"

std::string helloUser(const std::string& name)
{
    return "Hello " + name + "!";
}

std::string makeRequest(std::string endPoint)
{
    // YAML::Node config = YAML::LoadFile(endPoint);

    // if (config["lastLogin"])
    // {
    //     std::cout << "Last logged in: " << config["lastLogin"].as<DateTime>() << "\n";
    // }

    // const std::string username = config["username"].as<std::string>();
    // const std::string password = config["password"].as<std::string>();
    // return username + password;
    // login(username, password);
    // config["lastLogin"] = getCurrentDateTime();

    // std::ofstream fout("config.yaml");
    // fout << config;
}