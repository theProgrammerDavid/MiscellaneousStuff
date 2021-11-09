import ctypes

handle = ctypes.cdll.LoadLibrary("../build/lib/libchucknorris.so")
handle.chuck_norris_init.restype = ctypes.c_void_p
handle.chuck_norris_get_fact.restype = ctypes.c_char_p
handle.chuck_norris_get_fact.argtypes = [ctypes.c_void_p]
ck = handle.chuck_norris_init()
fact = handle.chuck_norris_get_fact(ck)
print(fact.decode('UTF-8'))
