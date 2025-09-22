count = 0

for char in range(ord('a'),ord('z') + 1) :
    print(f"{chr(char)} = {char}\t", end="\t")
    count += 1
    if(count % 5 == 0) :
        print()