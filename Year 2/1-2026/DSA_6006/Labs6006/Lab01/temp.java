import java.util.HashSet;

public class temp {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(2));
        System.out.println(set.add(4));
        System.out.println(set);    
    }
}
