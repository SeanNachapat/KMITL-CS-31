package packA;

public class Programmer extends EmpTmp {

    public Programmer(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    public void sayHi() {
        System.out.println("hi from " + name);
    }

    @Override
    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + "]";
    }

    public String coding() {
        return "I am coding.";
    }
}