import sympy as sym

t = sym.symbols('t')
cpu = 2*t

I = sym.factor(sym.integrate(cpu, (t, 0, 5)))

a = I / 5

print("Integral I =", I)
print("Average CPU usage =", sym.simplify(a), "%")