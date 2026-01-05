import sympy as sym
from sympy import pprint

a,b,t,T = sym.symbols('a, b, t, T')
f = a*t + b
I = sym.factor(sym.integrate(f, (t,0,T)))

a = sym.simplify(I/T)

print("Intregal I =")
pprint(I)
print("Average Bandwidth = I/T =")
pprint(a)