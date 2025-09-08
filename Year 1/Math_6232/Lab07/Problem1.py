def positiveIntegerCheck(n):
    try :
        numbers = float(n)
        if(numbers > 0) :
            print(f"{n} is a positive integer")
        else :
            print(f"{n} is not a positive integer")
    except :
        print(f"{n} is not a positive integer")

n = input("Please enter positive integer : ")
positiveIntegerCheck(n)