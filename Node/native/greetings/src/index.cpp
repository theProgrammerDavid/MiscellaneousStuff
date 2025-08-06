#include <napi.h>
#include <iostream>
#include <string>
#include "greeting.h"

Napi::String greetHello(const Napi::CallbackInfo &info)
{
    Napi::Env env = info.Env();
    // std::cout<<"no of args: "<<info.Length()<<"\n";
    // std::cout << "hello world";
    std::string result = helloUser(info[0].ToString());
    return Napi::String::New(env, result);
}

Napi::String makeGetRequest(const Napi::CallbackInfo &info)
{
    Napi::Env env = info.Env();
    std::string result = makeRequest(info[0].ToString());
    return Napi::String::New(env, result);
}

Napi::Object Init(Napi::Env env, Napi::Object exports)
{
    exports.Set(
        Napi::String::New(env, "greetHello"),
        Napi::Function::New(env, greetHello));

    // exports.Set(Napi::String::New(env, "makeGetRequest"),
    //             Napi::Function::New(env, makeGetRequest));

    return exports;
}

NODE_API_MODULE(greet, Init);