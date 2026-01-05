import sympy as sym
from sympy import pprint

x, y = sym.symbols('x, y')
f = sym.sin(x)**2 * sym.cos(x)
I = sym.integrate(f,x,y)

pprint(I)