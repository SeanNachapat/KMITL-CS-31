import sympy as sym

t = sym.symbols('t')
ping = 10 + 2 * sym.tan((sym.pi / 4) * t)
I = sym.simplify(sym.integrate(ping, (t, 0, 1)))

print("Integral I = ", I)