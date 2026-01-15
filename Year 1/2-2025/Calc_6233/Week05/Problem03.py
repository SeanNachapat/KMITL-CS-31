import sympy as sp

i = sp.symbols('i')
R = 1 / i**2

summation = sp.Sum(R, (i, 1, 30))
total_transfer = summation.doit().evalf()

print(f"ปริมาณข้อมูลที่ถ่ายโอนทั้งหมดสำหรับผู้ใช้ 30 คน คือ: {total_transfer:.5f} GB/s")