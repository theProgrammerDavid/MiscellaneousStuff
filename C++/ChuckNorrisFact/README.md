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

## Build JNA
Need to build shared libraries first
```bash
cd thirdparty && conan install .. && cd ../build &&
cmake -DBUILD_SHARED_LIBS=ON .. && make
```
Lets navigate back to `PROJECT_ROOT`
> Note: `${PROJECT_ROOT}` is the location of the folder contaiing `CMakeLists.txt`

```bash
mkdir java && cd java &&
mvn archetype:generate -DgroupId=com.chucknorris.app \
-DartifactId=java -DarchetypeArtifactId=maven-archetype-quickstart \
-DarchetypeVersion=1.4 -DinteractiveMode=false
```

Lets add the dependencies for `JNA`
In your `pom.xml`
```xml
<dependency>
    <groupId>net.java.dev.jna</groupId>
    <artifactId>jna</artifactId>
    <version>5.10.0</version>
</dependency>
```

Run the tests
```bash
mvn test "-Djna.library.path=${PROJECT_ROOT}/build/lib"
```
Note: `JNA` looks for the `.so` file in `jna.library.path` first and falls back to `java.library.path` if not found.