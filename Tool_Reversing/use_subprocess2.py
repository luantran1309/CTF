from subprocess import Popen, PIPE, STDOUT
stab = list('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789')
for a in stab:
    for b in stab:
        for c in stab:
            for d in stab:
                inp = a + b + c + d
                p = Popen(['gues.exe'], stdin=PIPE, stdout=PIPE, stderr=STDOUT)
                tmp  = p.communicate(f'{inp}'.encode())[0].rstrip()
                if b'KCSC' in tmp:
                    print(inp)
                    print(tmp)
                    exit(0)
