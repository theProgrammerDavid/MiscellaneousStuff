# ChuckNorris facts

## Setup
```bash
cd thirdpart && conan install ..
```

## Using python `ctypes`
```bash
mkdir build && cd build &&
cmake -DBUILD_SHARED_LIBS=ON .. && 
make &&
python3 chucknorris_ctypes.py
```

## Build `cffi`
```bash
python3 setup.py build_ext
python3 setup.py develop
```

## Build `wheel`
```bash
python3 setup.py bdist_wheel
```