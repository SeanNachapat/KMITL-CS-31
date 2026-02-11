import sympy as sym
import numpy as np
import matplotlib.pyplot as plt

t = sym.symbols('t')
I = sym.Function('I')
N = 1000
k = 0.05

ode = sym.Eq(I(t).diff(t), k*(N - I(t)))

sol = sym.dsolve(ode, I(t), ics={I(0): 0})
I_t = sol.rhs

eq_80 = sym.Eq(I_t, 0.8*N)
t_80 = sym.solve(eq_80, t)[0]
t_80_val = float(t_80.evalf())

t_vals = np.linspace(0, 100, 500)
I_vals = [float(I_t.subs(t, val).evalf()) for val in t_vals]

plt.figure(figsize=(10, 5))

curve_color = '#64b5f6'
dash_color = '#d6a5de'
marker_color = '#b01c2e'

plt.axhline(y=0.8*N, color=dash_color, linestyle='--', linewidth=2)
plt.axvline(x=t_80_val, color=dash_color, linestyle='--', linewidth=2)
plt.plot(t_vals, I_vals, color=curve_color, linewidth=5, label=r'$I(t) = N(1 - e^{-kt})$')
plt.plot(t_80_val, 0.8*N, marker='x', markersize=12, markeredgewidth=2, color=marker_color, linestyle='None', label=f'80% at $t \\approx {t_80_val:.2f}$ sec')
plt.title('Data Propagation in a Network', fontsize=12)
plt.xlabel('Time (seconds)', fontsize=10)
plt.ylabel('Number of devices with data', fontsize=10)
plt.xlim(0, 100)
plt.ylim(0, 1000)
plt.grid(True, which='both', axis='both', alpha=0.5)
plt.legend(loc='upper left', fontsize=10, frameon=True, framealpha=1, edgecolor='#d3d3d3')
plt.tight_layout()
plt.show()