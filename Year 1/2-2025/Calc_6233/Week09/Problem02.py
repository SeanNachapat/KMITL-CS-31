import sympy as sp
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.collections import LineCollection

x = sp.Symbol('x')
y = sp.Function('y')(x)

ode = sp.Eq(y.diff(x), y - x**2)

solution = sp.dsolve(ode, y, ics={y.subs(x, 0): 1})
y_exact = solution.rhs

y_func = sp.lambdify(x, y_exact, 'numpy')

x_vals = np.linspace(0, 2.5, 800)
y_vals = y_func(x_vals)

points = np.array([x_vals, y_vals]).T.reshape(-1, 1, 2)
segments = np.concatenate([points[:-1], points[1:]], axis=1)

fig, ax = plt.subplots(figsize=(7, 5))

norm = plt.Normalize(y_vals.min(), y_vals.max())
lc = LineCollection(segments, cmap='spring', norm=norm)

lc.set_array(y_vals) 
lc.set_linewidth(3)

line = ax.add_collection(lc)

ax.set_xlim(x_vals.min(), x_vals.max())
ax.set_ylim(y_vals.min() - 0.05, y_vals.max() + 0.05)

ax.set_title("Solution of y' = y - x^2 , y(0)=1")
ax.set_xlabel('x')
ax.set_ylabel('y(x)')

cbar = fig.colorbar(line, ax=ax)
cbar.set_label('y')

plt.tight_layout()
plt.show()