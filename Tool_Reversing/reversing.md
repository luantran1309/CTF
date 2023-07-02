# IDA pro
- comment: gõ /
- sửa tên biến, hàm: gõ N
## C in IDA
- **memset** là một hàm trong thư viện string.h của ngôn ngữ lập trình C. Nó được sử dụng để gán một giá trị nhất định cho một số byte liên tiếp trong bộ nhớ.
```c
void *memset(void *ptr, int value, size_t num);
```
**ptr**: con trỏ tới vùng nhớ cần thiết lập giá trị.
**value**: giá trị muốn thiết lập cho các byte trong vùng nhớ.
**num**: số lượng byte cần thiết lập.
# Assembly
- **setb** là lệnh dùng để thiết lập giá trị 1 thanh ghi thành 1 nếu cờ ZF được thiết lập ngược lại bằng 0