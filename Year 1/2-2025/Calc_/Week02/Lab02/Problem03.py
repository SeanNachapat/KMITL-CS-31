import sympy as sym
import numpy as np
import matplotlib.pyplot as plt

x = sym.symbols('x')
f = 1 / (1 + sym.exp(-x))

limitp = sym.limit(f, x, sym.oo)
limitn = sym.limit(f, x, -sym.oo)

print(f"Limit x -> infinity: {limitp}")
print(f"Limit x -> -infinity: {limitn}")

x = np.linspace(-5, 5, 200)
y = 1 / (1 + np.exp(-x))

plt.plot(x, y, color='blue', label="f(x)=1/(1+e^{-x})")

plt.text(0.5, 0.2, f'Sigmoid limit as x → ∞: {limitp}', color='blue', fontsize=10)
plt.text(0.5, 0.1, f'Sigmoid limit as x → -∞: {limitn}', color='blue', fontsize=10)

plt.title("f(x) = 1/(1+e**-x)")
plt.xlabel('x')
plt.ylabel('f(x)')
plt.show()