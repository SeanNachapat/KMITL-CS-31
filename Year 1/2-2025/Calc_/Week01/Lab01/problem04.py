import sympy as sym

x, y = sym.symbols('x y')
f = sym.simplify(sym.cos(x) * sym.cos(y) + sym.sin(x) * sym.sin(y))
print(f)