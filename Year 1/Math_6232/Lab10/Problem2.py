import random

words = ("apple", "banana", "cherry", "orange", "strawberry")
    
def showHint(list):
    print("Hint:", end=" ")
    for item in list:
        print(item, end=" ")
    print()
    
print(f"Welcome to Hangman!\n")
word = words[random.randint(0, len(words)-1)]
letters = list(word)
n = len(letters)+1
hint = []
for i in range(n-1):
  hint.append('_')  
randLetter = letters[random.randint(0, len(word)-1)]
for i in range(len(letters)) :
    if (randLetter == letters[i]) :
        hint[i] = randLetter

while(hint != letters) :
                
    showHint(hint)
    guess = input("Guess a letter:")
    if (guess in letters) :
        print(f"Correct guess:{guess}")
        for i in range(len(letters)) :
            if (guess == letters[i]) :
                hint[i] = guess
    else :
        print(f"Incorrect guess:{guess}")
        randLetter = letters[random.randint(0, len(word)-1)]
        if(randLetter not in hint) :
            for i in range(len(letters)) :
                if (randLetter == letters[i]) :
                    hint[i] = randLetter
    print()

print(f"Congratulations! You guessed the word '{word}' correctly!")