import sys
import string
from pwn import *
flag_chars = string.digits + string.ascii_letters + '_'

context.log_level = 'error'
def count_instructions(flag):
    valgrind_stderr = process(['valgrind', '--tool=cachegrind', './checkpass', 'picoCTF{'+flag+'}'])
    valgrind_stderr.revuntil("I   refs:")
    answer = int(valgrind_stderr.recvline().replace(',',''))
    return answer

passwrd_gues = '~' * 32
while any(x is '~' for x in passwrd_gues):
    best_count = count_instructions(passwrd_gues)
    print('gues so far is: '+ passwrd_gues)
    next_char = '~'
    for c in flag_chars:
        count = count_instructions(passwrd_gues.replace('~', c))
        if count > best_count:
            print('need a: '+ c)
            next_char = c
            break
    indexes = [x for x, v in enumerate(passwrd_gues) if v == '~']
    for i in indexes:
        trial_balloon= (passwrd_gues[:i] + next_char + passwrd_gues[i+1:])
        count = count_instructions(trial_balloon)
        if count > best_count:
            print('index is' + str(i))
            passwrd_gues = trial_balloon
            break
