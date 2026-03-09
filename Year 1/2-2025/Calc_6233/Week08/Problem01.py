import sympy as sym
import numpy as np
import matplotlib.pyplot as plt

t = sym.symbols('t')
T = sym.Function('T')(t)

differential_eq = sym.Eq(T.diff(t) + 0.3 * T, 30)
initial_conditions_list = [40, 50, 60, 70, 80]

plt.figure(figsize=(10, 6))
t_v = np.linsymace(0, 20, 400)

for T0 in initial_conditions_list:
    sol = sym.dsolve(differential_eq, T, ics={T.subs(t, 0): T0})
    
    T_f = sym.lambdify(t, sol.rhs, 'numpy')
    T_v = T_f(t_v)
    
    plt.plot(t_v, T_v, label=f'Initial CPU Temp = {T0}°C', linewidth=2.5)

plt.title('CPU Cooling Behavior Under Different Initial Loads', fontsize=14)
plt.xlabel('Time (seconds)', fontsize=12)
plt.ylabel('CPU Temperature (°C)', fontsize=12)
plt.grid(True)
plt.legend(loc='lower right')
plt.xlim(0, 20)
plt.ylim(38, 102)

plt.tight_layout()
plt.show()