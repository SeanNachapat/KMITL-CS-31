package packA;

public class Lec4Duck implements CanSwimIntf {
    @Override
    public void swim() {
        System.out.println("waddling");
    }

    public void duckMethod() {
        System.out.println("quack");
    }
}