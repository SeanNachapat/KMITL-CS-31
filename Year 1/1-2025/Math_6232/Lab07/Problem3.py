def invert(a : int):
    result = 0
    while(a > 1):
        result = int(result * 10 + a % 10)
        a /= 10 
    print(f"Inverse number is : {result}")
    
n = int(input("Please enter positive integer : "))
invert(n)