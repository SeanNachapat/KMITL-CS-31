count = 0

for i in range(1,101) :
    d = 0
    temp = i
    while(temp > 0) :
        d += temp % 10    
        temp = temp // 10
    if((i / d) == (i // d)) :
        print(i , end = " ")
        count += 1
        if(count % 10 == 0) :
            print()