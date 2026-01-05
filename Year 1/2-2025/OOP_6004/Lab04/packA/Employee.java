package packA;

abstract public class Employee {
    protected String name;
    protected int experience;
    protected int salary;

    public Employee(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    abstract public void sayHi();

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [name=" + name + ", experience=" + experience + ", salary=" + salary
                + "]";
    }
}
