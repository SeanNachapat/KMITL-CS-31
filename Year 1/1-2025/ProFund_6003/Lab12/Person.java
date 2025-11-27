class Person {
    String name;
    int saving;

    Person(String n, int amount) {
        name = n;
        saving = amount;
    }

    void introduce_self() {
        System.out.println("Hi, My name is " + name);
    }

    @Override

    public String toString() {
        return "I am " + name + ". My savings amount is " + saving;
    }

    boolean isWealthier(Person p) {
        return this.saving > p.saving;
    }

    public boolean equals(Object theOther) {
        if (this == theOther)
            return true;
        if (theOther == null)
            return false;
        if (getClass() != theOther.getClass())
            return false;
        Person p = (Person) theOther;
        if (this.name == null) {
            if (p.name != null)
                return false;
        } else if (!name.equals(p.name))
            return false;
        if (this.saving != p.saving)
            return false;
        return true;
    }

    int reward(Person p, int amount) {
        this.saving -= amount;
        p.saving += amount;
        return this.saving;
    }
}