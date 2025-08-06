#include <string>
class Singleton
{
protected:
    Singleton(const std::string value) : value_(value)
    {
    }

    static Singleton *singleton_;

    std::string value_;

public:
    Singleton(Singleton &other) = delete;
    void operator=(const Singleton &) = delete;

    static Singleton *GetInstance(const std::string &value);
    void SomeBusinessLogic()
    {
    }

    std::string value() const
    {
        return value_;
    }
};

Singleton *Singleton::singleton_ = nullptr;

Singleton *Singleton::GetInstance(const std::string &value)
{
    if (singleton_ == nullptr)
    {
        singleton_ = new Singleton(value);
    }
    return singleton_;
}