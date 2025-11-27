import math

initial_dose = 100 # ปริมาณยาเริ่มต้น 100 มิลลิกรัม
half_life = 4 # ยาจะมีชีวิตครึ่งหนึ่ง เมื่อกินยาไป 4 ชั่วโมง
duration = 24 # ระยะเวลาที่ต้องการคำนวณ 24 ชั่วโมง
interval = 2 # แสดงผลทุก 2 ชั่วโมง

def calk(half_life : int):
    return math.log(2) / half_life

dosage = {
    0 : initial_dose
}

for time in range(0, duration+1, interval):
    dosage[time] = initial_dose * math.e**(-(calk(half_life)*time))

print(f"""ปริมาณยาเริ่มต้น: {initial_dose} มิลลิกรัม
ครึ่งชีวิตของยา: {half_life} ชั่วโมง
ระยะเวลาที่คำนวณ: {duration} ชั่วโมง

      ความเข้มข้นของยาตามเวลา:
เวลา (ชั่วโมง) \t| ความเข้มข้น (มิลลิกรัม)
-----------------------------------""")
for time in dosage:
    print(f"\t]]{time}\t|\t{dosage[time]:.2f}")

print(f"เวลาที่ความเข้มข้นลดลงครึ่งหนึ่ง: {half_life} ชั่วโมง")