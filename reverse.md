# IDA 
### Kĩ thuật patch memory trong IDA pro
``` python
sus_key = bytes.fromhex("45 32 55 35 49")
for i in range(len(sus_key)):
    idc.patch_byte(0xAE8048+i, sus_key[i])
```
- patch_byte sẽ mov sus_key[i] vào 0xAE8048+i

### dump byte từ IDA
```python
bin= idc.get_bytes(addr,int(len))
```
- addr địa chỉ bắt đầu dump, len độ dài byte cần dump

### shift 12: để code script ngay trên IDA

### shift E: để push data
----
# GDB
### Lấy giá trị thanh ghi $r8 tính toán
``` python
gef➤ python print(''.join([chr(int(gdb.parse_and_eval(f"**($r8 + ({i} << 4))"))) for i in range(18)]))
```
### Use module gdb in python
- gdb -x file_name.py
----
# Python
### chuyển số nguyên sang byte(byte string)
```python
integer.to_bytes(length, byteorder, signed=False)
```
---
# Linux
### `stegseek` giấu tin trong file ảnh  
### `dirb` quét các file tồn tại trên Server
---
# Windows
### App `SoundDeep` ẩn tin(ảnh, file, ...) trong file âm nhạc(mp3,..) 
### App `Audacity` edit, record, ... âm thanh
