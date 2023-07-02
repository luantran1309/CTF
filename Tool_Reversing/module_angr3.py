#!/usr/bin/env python3
import angr
import claripy
import sys

def is_successful(state):
    #Successful print
    stdout_output = state.posix.dumps(1)
    return b'You got it!' in stdout_output

def should_abort(state):
    #Avoid this print
    stdout_output = state.posix.dumps(1)
    return b"That's wrong!" in stdout_output

proj = angr.Project('./chall')

flag = claripy.BVS("flag", 8 * 30)

state = proj.factory.entry_state(stdin = flag)

state.solver.add(flag.get_byte(0) == ord('n'))
state.solver.add(flag.get_byte(1) == ord('0'))
state.solver.add(flag.get_byte(2) == ord('0'))
state.solver.add(flag.get_byte(3) == ord('b'))
state.solver.add(flag.get_byte(4) == ord('z'))
state.solver.add(flag.get_byte(5) == ord('{'))

for i in range(6, 30):
    state.solver.add(flag.get_byte(i) >= 33)
    state.solver.add(flag.get_byte(i) <= 125)

sm = proj.factory.simulation_manager(state)

sm.explore(find=is_successful, avoid=should_abort)

if sm.found:
    sol = sm.found[0]
    print(sol.posix.dumps(sys.stdin.fileno()))
else:
    print("no sol")