import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Lab8_680123 {

    // create yindee preeda pramote in a static block for q2_3 - q2_6
    static Employee yindee = new Employee("yindee");
    static Employee preeda = new Employee("preeda");
    static Employee pramote = new Employee("pramote");

    static ArrayList<Employee> empList;
    static { // for q2_7
        empList = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("names.csv"))) {
            input.nextLine(); // skip first row
            while (input.hasNext()) {
                String row = input.nextLine().trim();
                empList.add(new Employee(row));
            }
            System.out.println("There are " + empList.size() + " employees.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        q1_1();
        q1_2();
        q1_3();
        q1_4();
        q1_5();

        q2_1();
        q2_2();
        q2_3();
        q2_4();
        q2_5();
        q2_6();
        q2_7();
        q2_8();
        q2_9();

        q3_1();
        q3_2();
        q3_3();
        q3_4();
        q3_5();
    }

    static void q1_1() {
        Employee emp1 = new Employee("yindee");
        Employee emp2 = new Employee("yindee");
        int id1 = emp1.hashCode();
        int id2 = emp2.hashCode();

        String s1 = Integer.toHexString(id1);
        String s2 = Integer.toHexString(id2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.compareTo(s2));
    }

    static void q1_2() {
        // java creates a copy of the reference when an obj is passed to a method.
        // changes to an obj will be effected
        Employee emp1 = new Employee("preeda");
        System.out.println(emp1);
        q1_2_sub(emp1);
        System.out.println(emp1);
    }

    private static void q1_2_sub(Employee emp) {
        emp.setName("aba abi abo abe");
    }

    static void q1_3() {
        // changes to an obj will be effected when passing as a parameter but
        // not a collection
        ArrayList<Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));
        System.out.println(singers.get(0)); // aba
        q1_3_sub(singers);
        System.out.println(singers.get(0)); // cha cha cha
        System.out.println(singers); // not empty because it's list who changes
    }

    private static void q1_3_sub(List<Employee> list) {
        list.get(0).setName("cha cha cha"); // changes takes effect
        list = new ArrayList<>(); // changes takes "no" effect on collection
    }

    static void q1_4() {
        // what if we do need to change the referenced object to another
        ArrayList<Employee> singers = new ArrayList<>();
        singers = q1_4_sub();
        System.out.println(singers);
    }

    private static ArrayList<Employee> q1_4_sub() {
        ArrayList<Employee> list = new ArrayList<>();
        // whether list is passed in or newly allocated, it's a local reference.
        list.add(new Employee("aba"));
        list.add(new Employee("abi"));
        return list;
    }

    static void q1_5() {
        // collection clone is shallow copy
        ArrayList<Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));

        System.out.println("singers = " + singers);

        @SuppressWarnings("unchecked") // by clone()
        List<Employee> tmp = (ArrayList<Employee>) singers.clone();
        tmp.get(0).setName("cha");
        System.out.println();
        System.out.println("singers = " + singers);
        System.out.println("tmp = " + tmp);

        // by new ArrayList<>();
        tmp = new ArrayList<>(singers);
        tmp.get(1).setName("cha cha");
        System.out.println();
        System.out.println("singers = " + singers);
        System.out.println("tmp = " + tmp);

        // by subList()
        tmp = singers.subList(0, singers.size() - 1);
        tmp.get(2).setName("cha cha cha");
        System.out.println();
        System.out.println("singers = " + singers);
        System.out.println("tmp = " + tmp);
    }

    static void q2_1() {
        List<Employee> singers1 = new ArrayList<Employee>(Arrays.asList(new Employee("aba"), new Employee("abi")));
        // Arrays.asList() returns fixed sized ...but ArrayList is not fixed, hence can
        // call addAll()
        List<Employee> singers2 = new ArrayList<>();
        singers2.add(new Employee("abo"));
        singers2.add(new Employee("abe"));

        System.out.println(singers1);
        System.out.println(singers2);

        List<Employee> addAllJoin = new ArrayList<>();
        addAllJoin.addAll(singers1);
        addAllJoin.addAll(singers2);
        System.out.println(addAllJoin);

        // make yourJoin hold value like addAllJoin
        List<Employee> yourJoin = q2_1_sub(singers1, singers2);
        System.out.println(yourJoin);

    }

    private static List<Employee> q2_1_sub(List<Employee> l1, List<Employee> l2) {
        // your implementation
        List<Employee> res = new ArrayList<>(l1);
        res.addAll(l2);
        return res;
    }

    static void q2_2() {
        List<Employee> singers = Arrays.asList(new Employee("aba"), new Employee("abi"));
        System.out.println(singers);
        singers = q2_2_sub(singers);
        System.out.println(singers);
    }

    private static List<Employee> q2_2_sub(List<Employee> list) {
        // your implementation
        return new ArrayList<>(list.subList(0, 1));
    }

    static void q2_3() {
        List<Employee> list1 = Arrays.asList(yindee, pramote);
        List<Employee> list2 = Arrays.asList(pramote, preeda);

        Set<Employee> empSet;
        empSet = new HashSet<>(list1);
        empSet.addAll(list2);
        List<Employee> newList = new ArrayList<>(empSet);

        System.out.println(newList);
    }

    static void q2_4() {
        Set<Employee> empSet1 = new HashSet<>(Arrays.asList(yindee, preeda, pramote));
        Set<Employee> empSet2 = new HashSet<>(Arrays.asList(yindee, pramote));

        empSet1.retainAll(empSet2);
        System.out.println(empSet1);
    }

    static void q2_5() {
        Set<Employee> empSet1 = new HashSet<>(Arrays.asList(yindee, preeda, pramote));
        Set<Employee> empSet2 = new HashSet<>(Arrays.asList(yindee, pramote));

        empSet1.removeAll(empSet2);
        System.out.println(empSet1);
    }

    static void q2_6() {
        Set<Employee> empSet = new HashSet<>(Arrays.asList(yindee, preeda, pramote, preeda));
        Employee[] empArr = new Employee[empSet.size()];
        // your implementation
        empArr = empSet.toArray(new Employee[0]);
        System.out.println(Arrays.toString(empArr));
    }

    static void q2_7() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // your implementation
            Employee e = empList.get(i);
            map.put(e.getName(), e);
        }

        System.out.println(map);
    }

    static void q2_8() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // your q12 implementation
            Employee e = empList.get(i);
            map.put(e.getName(), e);
        }
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
    }

    static void q2_9() {
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        pq.addAll(empList);
        List<Employee> fiveLeastSalary = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fiveLeastSalary.add(pq.poll());
        }
        System.out.println(fiveLeastSalary);

        List<Employee> fiveTopSalary = new ArrayList<>();
        // your implementation
        PriorityQueue<Employee> pqTop = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()));
        pqTop.addAll(empList);
        for (int i = 0; i < 5; i++) {
            fiveTopSalary.add(pqTop.poll());
        }
        System.out.println(fiveTopSalary);
    }

    static void q3_1() {
        int n = 5;
        String[] vote_for = { "Apple", "Banana", "Apple", "Orange", "Apple" };
        q3_1_sub(n, vote_for);
    }

    static void q3_1_sub(int n, String[] vote_for) {
        // your implementation
        Map<String, Integer> counts = new HashMap<>();
        for (String name : vote_for) {
            counts.put(name, counts.getOrDefault(name, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static void q3_2() {

        int n = 4;
        String[] inp = {
                "VISIT google.com",
                "VISIT stackoverflow.com",
                "BACK",
                "BACK" };

        // int n = 6;
        // String[] inp = {
        // "BACK",
        // "VISIT youtube.com",
        // "BACK",
        // "VISIT google.com",
        // "BACK",
        // "BACK" };

        q3_2_sub(n, inp);
    }

    static void q3_2_sub(int n, String[] inp) {
        // your implementation
        Stack<String> stack = new Stack<>();
        for (String s : inp) {
            if (s.startsWith("VISIT")) {
                stack.push(s.substring(6));
            } else if (s.equals("BACK")) {
                if (stack.isEmpty())
                    System.out.println("Empty (Nothing to BACK)");
                else
                    System.out.println("Back to: " + stack.pop());
            }
        }
    }

    static void q3_3() {
        int n = 4;
        String[] ops = {
                "ADD Homework 2",
                "ADD Exam 1",
                "NEXT",
                "NEXT" };

        // int n = 3;
        // String[] ops = {
        // "NEXT",
        // "ADD Homework 2",
        // "NEXT" };

        // int n = 6;
        // String[] ops = {
        // "ADD Homework 2",
        // "ADD Exam 1",
        // "NEXT",
        // "ADD Study 2",
        // "NEXT",
        // "NEXT"};
        q3_3_sub(n, ops);
    }

    static void q3_3_sub(int n, String[] inp) {
        // your implementation
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.priority, t2.priority));
        for (String s : inp) {
            String[] tokens = s.split(" ");
            if (tokens[0].equals("ADD")) {
                pq.add(new Task(tokens[1], Integer.parseInt(tokens[2])));
            } else if (tokens[0].equals("NEXT")) {
                if (pq.isEmpty())
                    System.out.println("Empty (Nothing to NEXT)");
                else
                    System.out.println("Working on: " + pq.poll().name);
            }
        }
    }

    static class Task {
        String name;
        int priority;

        Task(String n, int p) {
            this.name = n;
            this.priority = p;
        }
    }

    static void q3_4() {
        String inp = "wjmzbmr";
        // String inp = "xiaodao";
        // String inp = "sevenkplus";

        q3_4_sub(inp);
    }

    static void q3_4_sub(String inp) {
        // your implementation
        Set<Character> set = new HashSet<>();
        for (char c : inp.toCharArray())
            set.add(c);
        if (set.size() % 2 == 0)
            System.out.println("Girl");
        else
            System.out.println("Boy");
    }

    record SalesOrder(String item, double price, int aty, String category) {
    }// for 93_5() and 93_5_sub()

    static void q3_5() {
        String[] tmp = {
                "Latte 80.0 10 Coffee",
                "GreenTea 65.0 8 Tea",
                "Espresso 75.0 12 Coffee",
                "JasmineTea 55.0 10 Tea"
        };
        List<SalesOrder> transactions = new ArrayList<>();
        for (int i = 0; i < tmp.length; ++i) {
            String[] tokens = tmp[i].split("\\s+");
            double p = Double.parseDouble(tokens[1]);
            int q = Integer.parseInt(tokens[2]);
            transactions.add(new SalesOrder(tokens[0], p, q, tokens[3]));
        }
        q3_5_sub(transactions);
    }

    static void q3_5_sub(List<SalesOrder> transactions) {

        // Coffee : [Latte, Espresso]
        Map<String, List<String>> itemCategory = new HashMap<>();

        // build itemCategory while populating salesMap
        // Coffee: 800
        Map<String, Double> salesMap = new HashMap<>();

        // process transactions
        for (SalesOrder order : transactions) {
            // your implementation
            itemCategory.putIfAbsent(order.category(), new ArrayList<>());
            if (!itemCategory.get(order.category()).contains(order.item())) {
                itemCategory.get(order.category()).add(order.item());
            }
            salesMap.put(order.item(), order.price() * order.aty());
        }

        for (String category : itemCategory.keySet()) {
            System.out.println("Category: " + category);

            List<String> items = itemCategory.get(category);

            for (String item : items) {
                System.out.printf("\t- %-15s: %.2f\n", item, salesMap.get(item));
            }
        }
    }
}

class Employee {
    private Integer id;
    private String name;
    private Integer salary;

    public Employee(String n) {
        name = n;
        int sal = 0;
        for (int j = 0; j < name.length(); j++) {
            sal += name.charAt(j);
        }
        salary = sal;

        // q1_1
        // id = System.identityHashCode(this);
        id = System.identityHashCode(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " [" + name + "(" + salary + ")]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode()); // what if id is also the same
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id)) // what if id is also the same
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        return true;
    }
}