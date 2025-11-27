text = input()
result = ""

for index in range(len(text)):
    if index in [0, 2, 5]:
        result += text[index].upper()
    else:
        result += text[index]

print(result)