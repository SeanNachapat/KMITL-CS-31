import sympy as sp

x = sp.symbols('x')
n = sp.symbols('n')

term = (1 / 2**n) + (1 / 3**n)
summation = sp.Sum(term, (n, 1, sp.oo))

result = summation.doit()
result_decimal = result.evalf()

print(f"Summation result (Fraction): {result}")
print(f"Summation result (Decimal): {result_decimal}")