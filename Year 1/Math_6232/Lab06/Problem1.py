def calculate_compound_interest(**kwargs):
    Amount = kwargs['principal'] * (1 + kwargs['rate']/100)**kwargs['years']
    Benefit = Amount - kwargs['principal']
    return kwargs['principal'],kwargs['rate'],kwargs['years'],Amount,Benefit

def display_results(result : tuple):
    print(f"{'เงินต้น'} {result[0]:.2f} {'บาท'}")
    print(f"{'อัตราดอกเบี้ย'} {result[1]:.2f}{'%'} {'ต่อปี'}")
    print(f"{'ระยะเวลา'} {result[2]} {'ปี'}")
    print(f"{'จำนวนเงินสุดท้าย'} {result[3]:.2f} {'บาท'}")
    print(f"{'ดอกเบี้ยที่ได้รับ'} {result[4]:.2f} {'บาท'}")
    
result = calculate_compound_interest(principal=50000, rate=3, years=10)
display_results(result)