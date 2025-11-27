import math

hours = input("Hour : ")
perHour = 123.45
salary = perHour * float(hours)
baseSalary = 0

for i in range(int(hours)):
    baseSalary += math.ceil(perHour)

print("Salary : " + str(baseSalary) + " Baht")
print("Loss : " + str(baseSalary - salary) + " Baht")