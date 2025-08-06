{
    "targets": [
        {
            "target_name": "greet",
            "cflags": ["-fexceptions"],
            "cflags_cc":["-fexceptions"],
            "sources":[
                "./src/greeting.cpp",
                "./src/index.cpp"
            ],
            "libraries:":[
                # "./libyaml-cpp.a"
            ],
            "ldflags":[
                # "-Wl,-z,defs"
            ],
            "include_dirs": [
                "<!@(node -p \"require('node-addon-api').include\")",
                # "/home/david/dev/PostBaby/build/_deps/yamlcpp-src/include"
            ],
            "defines":["NAPI_DISABLE_CPP_EXCEPTIONS"],
        }
    ]
}
