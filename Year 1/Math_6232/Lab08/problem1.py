num = int(input("Please enter a positive integer : "))
n = num
result = 1
while(n >= 0) :
    if(n == 0) :
        result *= 1
        break
    result *= n
    n -= 1
print(f"The factorial of {num} is {result}")