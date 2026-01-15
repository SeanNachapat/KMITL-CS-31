import sympy as sp

x = sp.symbols('x')
n = sp.symbols('n')

f4 = sp.exp(x) * sp.sin(x)
ans4 = f4.series(x, 0, 5).removeO()
print(f"Taylor Series for e^x * sin(x): {ans4}")