import sympy as sym
from sympy import pprint

x, y, z = sym.symbols('x y z')
    
f = x**2 * y * sym.sin(z) + 8 * sym.cos(y)**2
I = sym.simplify(sym.integrate(f, x, y, z))
    
pprint(I)