package packA;

public class Salesperson extends EmpTmp {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        this.target = assignedTarget;
    }

    public Salesperson(String n, int exp) {
        super(n, exp, 0);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return this.target;
    }

    public void setSalary(int increasedAmount) {
        this.salary += increasedAmount;
    }

    public void setSalary() {
        this.salary += this.salary / 10;
    }

    public String makeQuotation() {
        return "Dear value customer, " + (int) (Math.random() * 1000) + " is my best offer.";
    }

    @Override
    public String toString() {
        return "Salesperson [name=" + name + ", target=" + target + "]";
    }
}
