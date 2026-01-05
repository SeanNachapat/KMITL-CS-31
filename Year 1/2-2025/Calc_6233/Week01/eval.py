import sympy as sym

print(sym.pi.evalf(100))
print(sym.N(2**(1/2), 30))
print(sym.N(sym.sqrt(2), 30))
print(round(0.1 + 0.2,2))