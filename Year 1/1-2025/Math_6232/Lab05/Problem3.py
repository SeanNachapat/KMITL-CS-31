def prime(n):
    if(n > 1 and (2**(n-1)) % n == 1 and n not in (561,1105,1729) or n == 2):
        return True
    else:
        return False
    
print(prime(int(input("input : "))))