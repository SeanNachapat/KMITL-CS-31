import sympy as sp

x = sp.symbols('x')
n = sp.symbols('n')

f5 = x / sp.sqrt(x**2 + 4)
ans5 = f5.series(x, 0, 6).removeO()
print(f"Taylor Series for x / sqrt(x^2 + 4): {ans5}")