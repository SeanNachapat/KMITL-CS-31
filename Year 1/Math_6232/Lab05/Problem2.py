def A(n):
    return(int(sum(range(n+1))))
def B(n):
    return(int(n*(n+1)/2))
def C(A,B):
    if(A == B):
        return True
    else:
        return False
    
input = int(input("Input : "))
print("Actual sum = " + str(A(input)))
print("Sum from formula = " + str(B(input)))
print("Results : " + str(C(A(5),B(5))))
