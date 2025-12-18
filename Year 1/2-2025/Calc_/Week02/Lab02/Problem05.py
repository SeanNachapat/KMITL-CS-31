import numpy as np
import sympy as sym

x, y = sym.symbols('x y')

fx = (1 - sym.cos(x**2 + y**2)) / ((x**2 + y**2) * (sym.exp(x**2 + y**2)))

limitx = sym.limit(fx, x, 1)
limity = sym.limit(limitx, y, -1)

print(limity)