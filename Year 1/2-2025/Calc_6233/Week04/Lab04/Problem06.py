import sympy as sym
from sympy import pprint

x, y, z = sym.symbols('x y z')
function = (x + y) / sym.sqrt(z)
result = sym.integrate(function, (x, 1, 2), (y, 3, 4), (z, 5, 6))

print(sym.factor(result))
pprint(result)