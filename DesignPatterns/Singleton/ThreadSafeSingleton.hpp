#pragma once
#include <string>
#include <mutex>

class Singleton
{

private:
    static Singleton *m_instance;
    static std::mutex m_mutex;

protected:
    Singleton(const std::string value) : value_(value) {}
    ~Singleton() {}
    std::string value_;

public:
    Singleton(Singleton &other) = delete;
    void operator=(const Singleton &) = delete;
    static Singleton *getInstance(const std::string &vauue);
    std::string value() const
    {
        return value_;
    }
};

Singleton *Singleton::m_instance{nullptr};
std::mutex Singleton::m_mutex;

Singleton *Singleton::getInstance(const std::string &value)
{
    std::lock_guard<std::mutex> lock(m_mutex);
    if (m_instance == nullptr)
    {
        m_instance = new Singleton(value);
    }
    return m_instance;
}