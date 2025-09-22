inventory = {
  "Laptop": 10,
  "Phone": 25,
  "Tablet": 15
}

def display_inventory():
    print("Inventory list:")
    for k,v in inventory.items():
        print(f"{k} : {v}")

def update_inventory():
    key = input("Enter the product name you want to update: ")
    if (key not in inventory):
        choice : str = input(f"{key} is not in the inventory. Would you like to add it? (y/n): ")
        if(choice == "y"):
            quantity = int(input("Enter the quantity to add: "))
            inventory[key] = quantity  
            print(f"Added new product {key} with quantity {quantity}.")          
    else:
        quantity = int(input("Enter the quantity to add or subtract: "))
        if (inventory[key] + quantity > 0):
            inventory[key] = inventory[key] + quantity
            print(f"The updated quantity of {key} is: {inventory[key]}")
        else:
            print(f"Cannot reduce the quantity of {key} because it will result in a negative amount!")
            

def delete_inventory():
    key : str = input(f"Enter the product name you want to delete: ")
    if (key not in inventory):
        print(f"{key} is not in the inventory!")
    else:
        choice : str = input(f"Are you sure you want to delete Tablet? (y/n): ")
        if(choice == "y") :
            inventory.pop(key)
            print(f"{key} has been deleted from the inventory.")


while (True) :
    print("""Inventory Management System:
1. View inventory list
2. Add/Reduce products
3. Delete products
4. Exit the program""")
    num = int(input("Select an option: "))
    
    print("")
    match num :
        case 1:
            display_inventory()
        case 2:
            update_inventory()
        case 3:
            delete_inventory()
        case 4:
            print("Exiting the program")
            break
    print("")