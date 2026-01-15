import numpy as np
import matplotlib.pyplot as plt
import sympy as sp

x = sp.symbols('x')
f = x**2 * sp.cos(x)**2

orders = [15, 20, 25, 30, 35, 40, 45, 50, 55]

x_vals = np.linspace(-10, 10, 500)

fig, axes = plt.subplots(3, 3, figsize=(15, 10))
axes = axes.flatten()

f_numeric = sp.lambdify(x, f, 'numpy')

for i, n in enumerate(orders):
    ax = axes[i]
    
    sol = f.series(x, x0=0, n=n).removeO()
    
    taylor_numeric = sp.lambdify(x, sol, 'numpy')
    
    ax.plot(x_vals, f_numeric(x_vals), label='Original', linestyle='--', color='#4c72b0')
    
    ax.plot(x_vals, taylor_numeric(x_vals), label=f'Taylor (n={n})', color='#dd8452')
    
    ax.set_title(f'n={n}')
    ax.set_ylim(0, 100)
    ax.set_xlim(-10, 10)
    ax.grid(True, alpha=0.5)
    ax.legend(loc='upper right', fontsize='small')
    
plt.tight_layout()
plt.show()