import sympy as sym
import numpy as np
import matplotlib.pyplot as plt

x = sym.symbols('x')
T = sym.Function('T')

ode = sym.Eq(T(x).diff(x) + 0.3*T(x), 30 + 10*sym.sin(0.5*x))

sol = sym.dsolve(ode, T(x))
gen_sol = sol.rhs
C1 = sym.symbols('C1')

T_values = [40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100]

x_vals = np.linspace(0, 20, 500)
c1_values = []

for T_value in T_values:
    c1_value = sym.solve(sym.Eq(gen_sol.subs(x, 0), T_value), C1)[0]
    c1_values.append(c1_value)

plt.figure(figsize=(12, 6))

for T_value, c1_value in zip(T_values, c1_values):
    specific_solution = gen_sol.subs(C1, c1_value)
    T_vals = [specific_solution.subs(x, val).evalf() for val in x_vals]
    plt.plot(x_vals, T_vals, label=f'y(0) = {T_value:.2f}, C1 = {float(c1_value):.2f}', linewidth=2.5)

plt.xlabel('Time (Seconds)', fontsize=12)     
plt.ylabel('CPU Temperature (°C)', fontsize=12)
plt.xlim(0, 20)
plt.ylim(40, 125)
plt.title('CPU Temperature Variation Over Time', fontsize=14)
plt.legend(loc='lower right', fontsize=9)

plt.grid(True)
plt.show()