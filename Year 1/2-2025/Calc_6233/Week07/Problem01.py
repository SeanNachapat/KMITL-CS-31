import sympy as sym

t = sym.symbols('t')
I = sym.Function('I')

N = 1000
k = 0.05

ode = sym.Eq(I(t).diff(t), k*(N - I(t)))
sol = sym.dsolve(ode, I(t), ics={I(0): 0})

I_t = sol.rhs
eq_80 = sym.Eq(I_t, 0.8*N)
t_80 = sym.solve(eq_80, t)[0]
t_80_val = t_80.evalf()

print("Solution of the differential equation:", sol)
print(f"Time required for data to spread to 80% of the network: {t_80_val:.2f} second")

