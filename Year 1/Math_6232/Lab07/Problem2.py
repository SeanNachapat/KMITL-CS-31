def Euclidean_Algorithm(a,b) :
    if b == 0 :
        return a
    else :  
        return Euclidean_Algorithm(b,a % b)
    
def GCD(a : int, b : int):
    try :
        n1 = float(a)
        n2 = float(b)
        if(n1 > 0 and n2 > 0) :
            result = int(Euclidean_Algorithm(n1,n2))
            print(f"GCD : {result}")
        else :
            print(f"{a,b} is not a positive integer, exit !!!")  
    except :
        print(f"{a,b} is not a positive integer, exit !!!")    
        
int1 = input("Positive Integer 1 : ")
int2 = input("Positive Integer 2 : ")
GCD(int1, int2)