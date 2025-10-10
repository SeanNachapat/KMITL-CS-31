def getInfo(prompt : str):
    try:
        info = input(prompt)
        if info != "":
            if info.strip(',') == "":
                raise ValueError("ข้อผิดพลาด: กรุณากรอกรายการสินค้าอย่างน้อยหนึ่งรายการ")
            set_info = info.split(', ')
            return set(set_info)
        else :
            raise ValueError("ข้อผิดพลาด: กรุณากรอกชื่อรายการสินค้าที่ถูกต้อง")
    except:
        raise ValueError("ข้อผิดพลาด: เกิดข้อผิดพลาดที่ไม่ทราบสาเหตุ")

print(f"-----------------------------------------------\n")

set_a = getInfo("กรอกรายการสินค้าที่มีอยู่แล้วในครัว: ")
set_b = getInfo("กรอกรายการสินค้าที่ต้องซื้อ: ")
  
print(f"\n-----------------------------------------------\n")

print(f"รายการสินค้าทั้งหมดที่ต้องมี: {set_a | set_b}")
print(f"รายการสินค้าที่ซ้ำกัน: {set_a & set_b}")
print(f"รายการสินค้าที่มีอยู่แล้วในครัว ไม่ต้องซื้ออีก: {set_a - set_b}")
print(f"รายการสินค้าที่ต้องซื้อแต่ไม่มีในครัว: {set_b - set_a}")
print(f"รายการสินค้าที่ไม่ซ้ำกัน: {set_b ^ set_a}")