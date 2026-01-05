package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {

    public ProgrammerManager(String name, int experience, int salary) {
        super(name, experience, salary);
        this.skills.add("solidity");
        this.skills.add("typescript");
    }

    @Override
    public void sayHi() {
        System.out.println("From sayHi, I know " + skills);
    }

    @Override
    public int evaluate(Programmer p) {
        int oldSalary = p.getSalary();
        int newSalary = (int) (oldSalary * 1.15);
        p.setSalary(newSalary);
        return newSalary;
    }

    @Override
    public String toString() {
        return "ManagerProgrammer [name=" + name + ", experience=" + experience + ", salary=" + salary + "]";
    }
}