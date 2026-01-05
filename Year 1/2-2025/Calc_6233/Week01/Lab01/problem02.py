import sympy as sym

a, b = sym.symbols('a b')
f = (a**(1/2) + b**(1/2)) * (a**(1/2) - b**(1/2))
expr = sym.expand(f)
print(expr)