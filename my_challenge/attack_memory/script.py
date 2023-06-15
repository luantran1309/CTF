import sys
import time

arr_limit = [1,2,4,8,16,32,64,128]
pwd = bytearray('.' * 37, 'utf8')
with open('path file', 'rb') as f:
    f.seek(0x89A)
    while True:
        code = f.read(4)
        offset = int.from_bytes(f.read(1), 'big')
        if f.read(3) == b'\x0F\xBE\xC0':
            code  = f.read(3)
            val = code[2]
            code  = f.read(8)
            cmpar = code[3]
            if cmpar == 0x85: #JNZ
                pwd[offset - 0x1c] &= ~val
            else:
                pwd[offset - 0x1c] |= val
        else:
            f.read(5)
            pwd[offset - 0x1c] &= 0b01111111  
        print(pwd.decode('utf8'),end='\r')
        time.sleep(0.02)
        sys.stdout.flush()
        if offset == 0x36 and val == 8:
            break
    while True:
        # break loop
        code = f.read(4)
        if code != b'\x0F\xB6\x44\x24':
            break
        offset = int.from_bytes(f.read(1), 'big')
        if f.read(3) == b'\x0F\xBE\xC0':
            code  = f.read(3)
            val = code[2]
            code  = f.read(4)
            cmpar = code[2]
            if cmpar == 0x75: #JNZ
                pwd[offset - 0x1c] &= ~val
            else:
                pwd[offset - 0x1c] |= val
        else:
            f.read(1)
            pwd[offset - 0x1c] &= 0b01111111 
        print(pwd.decode('utf8'),end='\r')
        time.sleep(0.02)
        sys.stdout.flush()
print()
