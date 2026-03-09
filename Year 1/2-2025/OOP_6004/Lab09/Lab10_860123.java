import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Lab10_860123 {

    record SalesOrder(String item, double price, int qty, String category) {
    }

    static List<SalesOrder> salesOrders = new ArrayList<>(List.of(
            new SalesOrder("Laptop Pro", 45000.0, 2, "Tech"),
            new SalesOrder("Mechanical Keyboard", 3500.0, 10, "Tech"),
            new SalesOrder("Wireless Mouse", 850.0, 25, "Tech"),
            new SalesOrder("Monitor 27 inch", 12000.0, 4, "Tech"),
            new SalesOrder("USB-C Hub", 1200.0, 15, "Tech"),
            new SalesOrder("Webcam 4K", 4500.0, 3, "Tech"),

            new SalesOrder("Leather Jacket", 5500.0, 2, "Cloth"),
            new SalesOrder("Cotton T-Shirt", 450.0, 50, "Cloth"),
            new SalesOrder("Denim Jeans", 1800.0, 15, "Cloth"),
            new SalesOrder("Wool Scarf", 800.0, 5, "Cloth"),
            new SalesOrder("Running Shoes", 3200.0, 8, "Cloth"),

            new SalesOrder("Organic Apple", 35.0, 120, "Fruit"),
            new SalesOrder("Golden Banana", 15.0, 200, "Fruit"),
            new SalesOrder("Imported Grapes", 150.0, 40, "Fruit"),
            new SalesOrder("Durian Monthong", 500.0, 10, "Fruit"),
            new SalesOrder("Sweet Mango", 60.0, 60, "Fruit"),

            new SalesOrder("Office Chair", 7500.0, 3, "Home"),
            new SalesOrder("Standing Desk", 15000.0, 2, "Home"),
            new SalesOrder("Table Lamp", 1200.0, 12, "Home"),
            new SalesOrder("Air Purifier", 9800.0, 5, "Home")));

    record WeatherLog(String city, double temp, double humidity, String date) {
    }

    static List<WeatherLog> weatherLogs = new ArrayList<>(List.of(
            new WeatherLog("Bangkok", 32.5, 88.0, "2024-03-01"),
            new WeatherLog("Bangkok", 35.2, 82.0, "2024-03-02"),
            new WeatherLog("Bangkok", 34.0, 85.0, "2024-03-03"),
            new WeatherLog("Bangkok", 31.8, 92.0, "2024-03-04"),

            new WeatherLog("Tokyo", 8.5, 45.0, "2024-03-01"),
            new WeatherLog("Tokyo", 10.2, 40.0, "2024-03-02"),
            new WeatherLog("Tokyo", 12.0, 38.0, "2024-03-03"),
            new WeatherLog("Tokyo", 5.5, 50.0, "2024-03-04"),

            new WeatherLog("London", 12.0, 90.0, "2024-03-01"),
            new WeatherLog("London", 11.5, 85.0, "2024-03-02"),
            new WeatherLog("London", 9.0, 95.0, "2024-03-03"),
            new WeatherLog("London", 14.2, 80.0, "2024-03-04"),

            new WeatherLog("Moscow", -12.5, 30.0, "2024-03-01"),
            new WeatherLog("Moscow", -15.0, 25.0, "2024-03-02"),
            new WeatherLog("Moscow", -10.2, 35.0, "2024-03-03"),
            new WeatherLog("Moscow", -5.0, 40.0, "2024-03-04"),

            new WeatherLog("Dubai", 42.0, 15.0, "2024-03-01"),
            new WeatherLog("Dubai", 45.5, 12.0, "2024-03-02"),
            new WeatherLog("Dubai", 43.8, 18.0, "2024-03-03"),
            new WeatherLog("Dubai", 40.0, 20.0, "2024-03-04")

    ));

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
        q7();
        q8();
        q9();
        q10();
        q11();
        q12();
        q13();
        q14();
        q15();
        q16();
        q17();
        q18();
        q19();
        q20();
    }
    static void q1() {
        List<Integer> input = List.of(1,2,3,4,5,6);
        input.stream().filter(n->n%2==0).forEach(n->System.out.print(n+" "));
        System.out.println();
    }

    static void q2() {
        String input = "Java Stream API is very powerful";
        Arrays.stream(input.split("\\W+")).filter(w->w.length()>5).forEach(w->System.out.print(w+" "));
        System.out.println();
    }

    static void q3() {
    List<String> input = List.of("Jeff", "Bill", "Mark", "Bob");
    Map<Character, List<String>> map =input.stream().collect(Collectors.groupingBy(n -> n.charAt(0), TreeMap::new, Collectors.toList()));
    map.forEach((k, v) -> System.out.println(k + ": " + v));
}

    static void q4() {
        List<String> input = List.of("Apple","Banana","Orange","Jeff","Bill","Mark","Bob");
        input.stream().skip(3).limit(2).forEach(s->System.out.print(s+" "));
        System.out.println();
    }

    static void q5() {
        List<String> input = List.of("Milk","Orange","Apple","Banana","Orange","Water","Coke","Apple","Milk");
        input.stream().distinct().sorted().forEach(s->System.out.print(s+" "));
        System.out.println();
    }

    static void q6() {
        List<String> input = List.of("Jeff","Bill","Mark");
        System.out.println(input.stream().collect(Collectors.joining(", ")));
    }

    static void q7() {
        List<String> input = List.of("Java","Stream","API");
        input.stream().map(String::length).forEach(n->System.out.print(n+" "));
        System.out.println();
    }

    static void q8() {
        List<List<Integer>> input = List.of(List.of(1,2),List.of(2,3),List.of(4,5));
        System.out.println(input.stream().flatMap(List::stream).distinct().sorted().toList());
    }

    static void q9() {
        List<Double> input = List.of(1.5,2.5,5.0);
        System.out.println(input.stream().mapToDouble(Double::doubleValue).average().orElse(0));
    }

    static void q10() {
        String input="abcd";
        double avg=input.chars().average().orElse(0);
        System.out.println((char)Math.round(avg));
    }

    static void q11() {
        salesOrders.stream().collect(Collectors.groupingBy(SalesOrder::category,Collectors.summingDouble(o->o.price()*o.qty()))).forEach((k,v)->System.out.println(k+": "+v));
    }

    static void q12() {
    salesOrders.stream().sorted((a, b) -> Double.compare(b.price(), a.price())).limit(3).forEach(o -> System.out.println(o.item() + ": " + o.price()));
    }

    static void q13() {
        salesOrders.forEach(o->System.out.println(o.item()+": "+(o.price()*0.85)));
    }

    static void q14() {
        Map<String,Double> discount=Map.of("Home",0.15,"Tech",0.20,"Cloth",0.10,"Fruit",0.05);salesOrders.forEach(o->{double newPrice=o.price()*(1-discount.get(o.category()));System.out.println(o.item()+": "+newPrice);});
    }

    static void q15() {
        DoubleSummaryStatistics stats = salesOrders.stream().mapToDouble(o->o.price()*o.qty()).summaryStatistics();
        System.out.printf("Min: %.2f Max: %.2f Average: %.2f Sum: %.2f%n",stats.getMin(),stats.getMax(),stats.getAverage(),stats.getSum());
    }

    static void q16() {
        System.out.println(weatherLogs.stream().mapToDouble(WeatherLog::temp).average().orElse(0));
    }

    static void q17() {
        weatherLogs.stream().collect(Collectors.groupingBy(WeatherLog::city,Collectors.averagingDouble(WeatherLog::temp))).forEach((k,v)->System.out.println(k+": "+v));
    }

    static void q18() {
        weatherLogs.stream().collect(Collectors.groupingBy(WeatherLog::city,Collectors.summarizingDouble(WeatherLog::temp))).forEach((city,stats)->{double max=stats.getMax(); double min=stats.getMin(); System.out.printf("%s: %.2f %.2f %.2f%n",city,max,min,max-min);});
    }

    static void q19() {
        weatherLogs.stream().map(w->{String status = w.temp()>30?"Hot":w.temp()<12?"Cold":"Normal";return "Date: "+w.date()+" | City: "+w.city()+" | Status: "+status;}).forEach(System.out::println);
    }

    static void q20() {
        weatherLogs.stream().collect(Collectors.groupingBy(WeatherLog::city,Collectors.filtering(w->w.humidity()>60,Collectors.counting()))).forEach((k,v)->System.out.println(k+": "+v));
    }
}