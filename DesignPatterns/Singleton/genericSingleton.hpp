template <class T, class CONTEXT>
class Singleton
{
public:
    // stuff

protected:
    Singleton()
    {
    }

private:
    static T *m_instance;
};

template <class T, class CONTEXT>
T *Singleton<T, CONTEXT>::m_instance;

class Logger
{
};
class LoggerSingleton : public Singleton<Logger, LoggerSingleton>
{
};

void doSomething()
{
}