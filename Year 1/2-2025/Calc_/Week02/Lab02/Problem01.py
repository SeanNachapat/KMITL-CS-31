import sympy as sym

n = sym.symbols('n')
y = (n**2 + 3*n + 4) / (2*n**2 + 5)
h = sym.limit(y,n, sym.oo)
print(float(h))