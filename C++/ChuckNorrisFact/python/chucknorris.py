from _chucknorris import lib, ffi

class ChuckNorris:
    def __init__(self):
        self._ck = lib.chuck_norris_init()

    def get_fact(self):
        c_fact = lib.chuck_norris_get_fact(self._ck)
        return ffi.string(c_fact).decode('UTF-8')
    
    def __del__(self):
        lib.chuck_norris_deinit(self._ck)
    

def main():
    chuck_norris = ChuckNorris()
    print(chuck_norris.get_fact())

if __name__ == "__main__":
    main()