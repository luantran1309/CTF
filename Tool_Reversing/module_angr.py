import angr 
import claripy

def main(): 
    path = "E:\\test\\bin\every_bit_counts" # đường dẫn đến file cần phân tích

def good(state):  
    return b'Wow you found my flag' in state.posix.dumps(1)  # state.posix.dumps(1) lấy stdout

def bad(state):
    return b'This is not my flag!' in state.posix.dumps(1)

proj = angr.Project("E:\\test\\bin\every_bit_counts")
# argv1 = claripy.BVS('arg1', 52*8) # tạo biến symbolic 52 bytes
m_args = [proj.filename, claripy.BVS('arg1', 52*8)] 
state = proj.factory.entry_state(args=m_args)
simulation = proj.factory.simgr(state)
simulation.explore(find=good, avoid=bad)
if simulation.found:
    solution_state = simulation.found[0] # lấy trạng thái đầu tiên trong ds trạng thái được tìm thấy
    print(simulation.found[0].posix.dumps(1))
    # stdout
    print(simulation.found[0].posix.dumps(0))
    # stdin such as input by scanf
    print(solution_state.solver.eval(m_args[1], cast_to=bytes)) # In giá trị của argv1
    # commandline input, flag
else:
    print("NO")
main()