import angr
import claripy

proj = angr.Project('./give_me_password', auto_load_libs = False)

#start_addr = 0x40090e
#find_addr = 0x4009d7
#avoid_addr = 0x400970

state = proj.factory.entry_state()
#state = proj.factory.blank_state(addr = start_addr)

#arg = state.solver.BVS("imput_string", 8 * 128)

#bind_addr = 0x700038
#state.memory.store(bind_addr, arg)
#state.add_constraints(state.regs.rdi == bind_addr)

simgr = proj.factory.simulation_manager(state)
simgr.explore(find = lambda s:b"correct" in s.posix.dumps(1))

if simgr.found:
    for found in simgr.found:
        #flag = found.solver.eval(arg, cast_to = bytes)
        #print("|", flag[:flag.index(b'\x00')].decode(), "|", sep = "")
        flag = found.posix.dumps(0)
        print(flag[:flag.index(b'\x00')].decode())
else:
    print("Not found.")

