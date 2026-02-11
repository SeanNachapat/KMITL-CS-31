import sympy as sp

i = sp.symbols('i')
R = 1 / i**2

sum = sp.Sum(R, (i, 1, 30))
tt = sum.doit().evalf()

print(f"ปริมาณข้อมูลที่ถ่ายโอนทั้งหมดสำหรับผู้ใช้ 30 คน คือ: {tt:.5f} GB/s")