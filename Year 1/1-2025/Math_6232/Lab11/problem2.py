def encrypt(message = "", shift = 0):
    print("========================")
    print(f"{message} ถูกเข้ารหัสเป็น: {ceasar(message, shift)}")
    print("========================")
    
def decrypt(message = "", shift = 0):
    print("========================")
    print(f"{message} ถูกเข้ารหัสเป็น: {ceasar(message, shift*(-1))}")
    print("========================")
    
def ceasar(message = "", shift = 0):
    all_chars = "abcdefghijklmnopqrstuvwxyz"
    try:
        sel_char = ""
        for char in message:
            if char.isalpha():
                is_upper = char.isupper()
                char_lower = char.lower()
                index = all_chars.find(char_lower)
                new_index = (index + shift) % len(all_chars)
                new_char = all_chars[new_index]
                if is_upper:
                    sel_char += new_char.upper()
                else:
                    sel_char += new_char
            else:
                if char.isdigit():
                    sel_char += str((int(char)-shift) % 10)
                else:
                    sel_char += char    
        reversed = [x[::-1] for x in sel_char.split(" ")]
        return " ".join(reversed)
    except ValueError:
        print(ValueError)
                
def check_int(num):
    try:
        int(num)
        return True
    except ValueError:
        return False

def shift_data():
    shift = input(f"กรอกจำนวนตัวอักษรที่ต้องการเลื่อน\n")
    while not check_int(shift):
        shift = input(f"กรอกจำนวนตัวอักษรที่ต้องการเลื่อน\n")
    return int(shift)

select = ""
while select != "q":
    select = input(f"\nกด e เข้ารหัส กด d ถอดรหัส q ออกจากโปกแกรม\n").lower()
    if(select == "e"):
        message = input(f"กรอกข้อความที่ต้องการเข้ารหัส\n")
        shift = shift_data()
        encrypt(message, shift)
    elif(select == "d"):
        message = input(f"กรอกข้อความที่ต้องการถอดรหัส\n")
        shift = shift_data()
        decrypt(message, shift)