def capitalize(text):
    result = ""
    for index in range(len(text)):
        if index == 0:
            result += text[index].upper()
        else:
            result += text[index]
    return result    

text = input()
print(capitalize(text))