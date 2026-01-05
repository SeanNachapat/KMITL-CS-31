import numpy as np
import sympy as sym

x, y = sym.symbols('x y')

fx = (x*y) / (sym.sqrt(x*y+1) - 1)

limitx = sym.limit(fx, x, 0)
limity = sym.limit(limitx, y, 0)

print(limity)