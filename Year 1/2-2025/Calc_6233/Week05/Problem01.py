import sympy as sym
import numpy as np
import matplotlib.pyplot as plt

t = sym.symbols('t')
f = 1/(1+t)
sol = f.series(t, x0=1, n=5).removeO()
f_numeric = sym.lambdify(t, f, 'numpy')
taylor_numeric = sym.lambdify(t, sol, 'numpy')

t_val = np.linspace(-1,3,500)

plt.figure(figsize=(10, 6))

plt.plot(t_val, f_numeric(t_val), label='1/(1+t)', linestyle='--', linewidth=2, color='#4c72b0')

expansion_str = str(sol).replace('**', '^')
plt.plot(t_val, taylor_numeric(t_val), label=f'Taylor Series Expansion\n{expansion_str}', color='#dd8452', linewidth=2)
plt.axvline(x=1, color='#c44e52', linestyle='--', linewidth=2, label='Expansion Center (t = 1)')

plt.title('Taylor Series Expansion of 1/(1+t) around t = 1')
plt.xlabel('t')
plt.ylabel('P(t)')
plt.grid(True, which='both', linestyle='-', alpha=0.8)
plt.xlim(-1,3) 
plt.ylim(0,100)
plt.legend(loc='upper right')

plt.tight_layout()
plt.show()