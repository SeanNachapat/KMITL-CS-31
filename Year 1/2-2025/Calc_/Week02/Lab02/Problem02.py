import sympy as sym

x,y = sym.symbols('x,y')
p = (5*x**2 + 7*y) / (3*x**2 + 2*x*y + y**2) 
p = p.subs(y,10)
h = sym.limit(p, x, sym.oo)
print(round(float(h),5))