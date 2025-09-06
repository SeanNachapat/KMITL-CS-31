import math

hours = input("Hour : ")
salary = 123.5 * float(hours)
print("Salary : " + str(math.ceil(salary)) + " Baht")
print("Loss : " + str(math.ceil(salary) - salary) + " Baht")