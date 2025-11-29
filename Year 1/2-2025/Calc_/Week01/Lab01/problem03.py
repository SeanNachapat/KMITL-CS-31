import sympy as sym

x = sym.symbols('x')
h = sym.factor(6*x**4 + 28*x**3 - 7*x**2 + 14*x - 5)
print(h)