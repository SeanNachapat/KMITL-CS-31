package packA;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public EmpTmp(String n, int exp, int sal) {
        this.name = n;
        this.salary = sal;
        this.experience = exp;
    }

    public EmpTmp(String n) {
        this.name = n;
    }

    public EmpTmp() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public int getSalary() {
        return salary;
    }

    public void setExperience(int exp) {
        this.experience = exp;
    }

    public int getExperience() {
        return this.experience;
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }

    public void sayHi() {
        System.out.println("Hi from an EmpTmp instance. (if derived class does not override this method is invoked.)");
    }
}
