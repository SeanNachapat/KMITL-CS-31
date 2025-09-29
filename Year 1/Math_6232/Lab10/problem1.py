import time
import random
import os
    
def fibo(n : int) -> int:
    if n in {0,1}:
        return n
    return fibo(n-1) + fibo(n-2)

def rand(n) -> int:
    counter : int = 0
    for i in range(3):
        randFibo = []
        while len(randFibo) < 5:
            rdm = n[random.randint(0, len(n)-1)]
            if (rdm not in randFibo) :
                randFibo.append(rdm)
        print(f"Remember this sequence: {randFibo}")
        time.sleep(5)
        os.system("cls")
            
        rawAns = input("Enter the Fibonacci sequence: ").split()
        ans = []
        [ans.append(int(rawAns[i])) for i in range(len(rawAns))]
        print(ans)
        if ans == randFibo:
            print("Correct!")
            counter+=1 
        else : 
            print(f"Wrong! The correct sequence was {randFibo}")
    
    print(f"You guessed correctly in {counter} out of 3 rounds.")
        
 
print(f"--- Fibonacci Memory Game ---")
choice = int(input("Choose difficulty level (1 = Easy, 2 = Medium, 3 = Hard):"))

match choice :
    case 1 :
        rand([fibo(n) for n in range(10+1)])
    case 2 :
        rand([fibo(n) for n in range(20+1)])
    case 3 :
        rand([fibo(n) for n in range(30+1)])
    case _ :
        exit

