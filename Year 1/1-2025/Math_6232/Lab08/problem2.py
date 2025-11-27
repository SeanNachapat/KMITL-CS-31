n = int(input("Enter the multiplication table you want : "))
i = 12
while True :
    print(f"{n} * {i} = {n * i}")
    i -= 1
    if(i == 0) :
        break