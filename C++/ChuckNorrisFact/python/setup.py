from setuptools import setup, find_packages

setup(
    name="chucknorris",
    version="0.1",
    description="chucknorris python3 bindings",
    author="David Velho",
    py_modules=["chucknorris"],
    setup_requires=["cffi"],
    cffi_modules=["build_chucknorris.py:ffibuilder"],
    install_requires=["cffi", "path.py"],
)
