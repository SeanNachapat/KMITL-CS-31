def calculator() :
    print("############################")
    print("#   Please select choice   #")
    print("############################")
    print("# 1. Plus      (+)         #")
    print("# 2. Minus     (-)         #")
    print("# 3. Multiply  (*)         #")
    print("# 4. Divide    (/)         #")
    print("# 5. Power     (**)        #")
    print("############################")
    n = int(input("Select : "))
    if(n >= 1 and n <= 5) :
        num1 = float(input("Enter number 1 : "))
        num2 = float(input("Enter number 2 : "))
        match n :
            case 1 :
                print(f"{num1:.2f} + {num2:.2f} = {num1 + num2:.2f}")
            case 2 :
                print(f"{num1:.2f} - {num2:.2f} = {num1 - num2:.2f}")
            case 3 :
                print(f"{num1:.2f} * {num2:.2f} = {num1 * num2:.2f}")
            case 4 :
                print(f"{num1:.2f} / {num2:.2f} = {num1 / num2:.2f}")
            case 5 :
                print(f"{num1:.2f} ** {num2:.2f} = {num1 ** num2:.2f}")
    else :
        print("Please select choice 1-5 only")
        calculator()

calculator()
