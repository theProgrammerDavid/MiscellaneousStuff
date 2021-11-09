# ChuckNorris facts

## Setup
```bash
cd thirdpart && conan install ..
```

## Using python `ctypes`
```bash
mkdir build && cd build &&
cmake -DBUILD_SHARED_LIBS=ON .. && 
make && cd python &&
python3 chucknorris_ctypes.py
```

## Build `cffi`
```bash
cd python &&
python3 setup.py build_ext &&
python3 setup.py develop
```

## Build `wheel`
```bash
cd python &&
python3 setup.py bdist_wheel
```