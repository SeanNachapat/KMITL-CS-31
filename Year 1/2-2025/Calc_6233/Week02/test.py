import time
import sympy as sym

x = sym.symbols('x')
t = time.time()
y = (1-sym.sqrt(sym.cos(x)))/(x*(1-sym.cos(sym.sqrt(x))))
sol = sym.diff(y,x,20)

print(sol)
elapsed = time.time()-t

print()
print(elapsed)