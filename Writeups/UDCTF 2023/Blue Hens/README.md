### Hint
```Last year the feedback was "maybe not so many esolangs". I hear you. So I just wrote one. OK? The linguistic root of the word scholarly is "spare time".

Blue Hens

Your input is a file of code.

Each line has the word "blue" some number of times followed by the word "hens" some number of time (separated by spaces).

The number of "blues" on the line is the OPCODE the number of "hens" on that line is the ARG. The line numbers matter and they start at 1.

Our architecture has 2 variables, a register and a counter both start at 0.

OPCODES 1,2,3,4 are arithmetic operations:

1 is SET: set the register to the ARG

2 is ADD: add the ARG to the register

3 is SUB: subtract ARG from the register

4 is MUL: multiply the register by ARG

OPCODES 5,6,7 are gotos

5 is GTL: go to line number ARG

6 is GBL: go back ARG lines

7 is GUL: go forward ARG lines

OPCODES 8,9,10 are control flow:

8 is CTA: add ARG to counter

9 is CTS: subtract ARG from counter

10 is SKP: skip the next line IF counter is 0

OPCODE 11 is print:

11 is PRT: print the value of the register (ascii)
```
- Bài này nó sẽ đếm số `blue` và `hens` ở mỗi dòng cho ra `OPCODES` và `arg` 
- Tạo 2 thanh ghi là res và counter để quản lý
### Solve:
```python
OPCODES  = [0] * 12
OPCODES[1] =  'SET'
OPCODES[2] =  'ADD'
OPCODES[3] =  'SUB'
OPCODES[4] =  'MUL'
OPCODES[5] =  'GTL'
OPCODES[6] =  'GBL'
OPCODES[7] =  'GUL'
OPCODES[8] =  'CTA'
OPCODES[9] =  'CTS'
OPCODES[10] =  'SKP'
OPCODES[11] =  'PRT'
content = [0]
with open ('flag.bluehens', 'r') as f:
    text = f.read()

for line in text.split('\n'):
    opcode = 0
    arg = 0
    for s in line.split():
        if s == 'blue':
            opcode += 1
        else:
            arg += 1
    content.append([OPCODES[opcode], arg])

index = 1
res = 0
counter = 0
while(index != 114):
    if content[index][0] == 'SET':
        res = content[index][1]
    elif content[index][0] == 'ADD':
        res += content[index][1]
    elif content[index][0] == 'SUB':
        res -= content[index][1]
    elif content[index][0] == 'MUL':
        res *= content[index][1]
    elif content[index][0] == 'GTL':
        index = content[index][1]
        continue
    elif content[index][0] == 'GBL':
        index -= content[index][1]
        continue
    elif content[index][0] == 'GUL':
        index += content[index][1]
        continue
    elif content[index][0] == 'CTA':
        counter += content[index][1] 
    elif content[index][0] == 'CTS':
        counter -= content[index][1]
    elif content[index][0] == 'SKP':
        if counter == 0:
            index += 2
            continue
    elif content[index][0] == 'PRT':
        print(chr(res),end='')
    index += 1
```
# Chúc mn học tập tốt :))