import sympy as sym

# Expand Equation 
x = sym.symbols('x')
f = (x + 5) * (x - 3)
expr = sym.expand(f)
print(expr)

# Trigonometry formula
x, y = sym.symbols('x y')
g = sym.expand(sym.cos(x+y), trig=True)
print(g)

# Polynomial Factor
x = sym.symbols('x')
h = sym.factor(6*x**3 + 11*x**2 - 16*x - 21)
print(h)

# Simplify Equation
x,y = sym.symbols('x y')
u = sym.simplify((x + 2*y)/(2/x + 1/y))
print(u)

x = sym.symbols('x')
u = sym.simplify((2*x**5 - 5*x**4 + 58*x - 145) / (2*x - 5))
print(u)