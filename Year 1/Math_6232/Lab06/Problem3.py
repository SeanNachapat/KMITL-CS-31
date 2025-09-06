import math

def calculate_angles(A : int, a : float, b : float) -> float:
    """
    Find B from angle A, side a and b

    Args:
        A (int): The first angle.
        a (float): The first side.
        b (float): The second side.

    Returns:
        float: Angle B in degree.
    """
    sinA = math.sin(math.radians(A))
    sinB = sinA * b / a
    B = math.degrees(math.asin(sinB))
    return B
    
    
A = 30
a = 2.5
b = 3.41
print(f"มุม B ประมาณ {calculate_angles(A, a, b):.2f} องศา")