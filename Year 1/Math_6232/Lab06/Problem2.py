import math

def calculate_angles(a : int, b : int, c : int) -> tuple:
    """
    Find angle A,B,C from length of a,b,c

    Args:
        A (float): Angle A.
        B (float): Angle B.
        C (float): Angle C.
        a (float): Side a.
        b (float): Side b.
        c (float): Side c.

    Returns:
        Tuple: Angle A, Angle B, Angle C in degree.
    """
    angleA = math.degrees(math.acos((b**2 + c**2 - a**2)/ (2*b*c)))
    angleB = math.degrees(math.acos((a**2 + c**2 - b**2)/ (2*a*c)))
    angleC = math.degrees(math.acos((b**2 + a**2 - c**2)/ (2*b*a)))
    return angleA, angleB, angleC
    
def sum_of_angles(a : int, b : int, c : int) -> tuple:
    """
    Find sum of angle A,B,C from the function calculate_angles(a,b,c)
    
    Args:
        A (float): Angle A.
        B (float): Angle B.
        C (float): Angle C.
        a (float): Side a.
        b (float): Side b.
        c (float): Side c.
        sum (float) : The sum of angle A,B,C.

    Returns:
        Tuple: (float)Sum of angle A,B,C ,(boolean) is sum equal 180.
    """
    A,B,C = calculate_angles(a,b,c)
    sum = A+B+C
    return sum, sum == 180 

a = 12
b = 7
c = 8

A,B,C = calculate_angles(a,b,c)
sumOfAngle, isSumEqual = sum_of_angles(a,b,c)


print(f" Angle A = {A:.2f}\n Angle B = {B:.2f}\n Angle C = {C:.2f}")
print(f"Sum of internal angles = {sumOfAngle:.2f} \nIs the sum equal to 180?: {isSumEqual}")