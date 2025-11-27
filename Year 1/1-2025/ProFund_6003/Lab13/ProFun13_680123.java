import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProFun13_680123 {
    public static void main(String[] args) {
        // demo1();
        // demo2();
        // demo3();
        // demo4();
        demo5();
    }

    static void demo1() {
        try (Scanner input = new Scanner(Paths.get("movies.csv"))) {
            while (input.hasNextLine()) {
                String row = input.nextLine();
                String[] tokens = row.split(",");
                int year = Integer.parseInt(tokens[1]);
                double rating = Double.parseDouble(tokens[2]);
                System.out.println(tokens[0] + "," + year + "," + rating);
            }
        } catch (IOException e) { // never expected this error cause example of causes are file-not-found,
                                  // IO-Error
            e.printStackTrace();
        }
    }

    static void demo2() {
        int rowNum = 1;
        try (Scanner input = new Scanner(Paths.get("movies2.csv"))) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    System.out.println(
                            tokens[0] + "," + Integer.parseInt(tokens[1]) + "," + Double.parseDouble(tokens[2]));
                } catch (Exception e) { // in fact, (NumberFormatException nfe)
                    System.out.println("At row " + rowNum + ", exception name is " + e + "... skip");
                } finally {
                    rowNum++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void demo3() {
        int rowNum = 1;
        try (Scanner input = new Scanner(Paths.get("movies.csv"))) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    Movie m = new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                    System.out.println(m);
                } catch (Exception e) { // in fact, (NumberFormatException nfe)
                    System.out.println("At row " + rowNum + ", exception name is " + e + "... skip");
                } finally {
                    rowNum++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void demo4() {
        int rowNum = 1;
        ArrayList<Movie> lis = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("movies2.csv"))) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    Movie mov = new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                    lis.add(mov);
                } catch (Exception e) { // in fact, (NumberFormatException nfe)
                    System.out.println("At row " + rowNum + ", exception name is " + e + "... skip");
                } finally {
                    rowNum++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Movie m : lis) {
            System.out.println(m);
        }
    }

    static void demo5() {
        MovieCounter location1 = new MovieCounter();
        MovieCounter location2 = new MovieCounter();

        System.out.println("location 1");
        location1.showAvailableList();
        System.out.println("location 2");
        location2.showAvailableList();

        location1.checkOut(1);
        location2.checkOut(2);

        System.out.println("***after some activities***");
        System.out.println("location 1");
        location1.showAvailableList();
        location1.showCheckOutList();
        System.out.println("location 2");
        location2.showAvailableList();
        location2.showCheckOutList();

    }
}

class MovieCounter {
    ArrayList<Movie> availableList;
    ArrayList<Movie> checkOutList;

    public MovieCounter() {
        this.availableList = new ArrayList<>();
        this.checkOutList = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("movies2.csv"))) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    Movie mov = new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                    this.availableList.add(mov);
                } catch (Exception e) { // in fact, (NumberFormatException nfe)
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAvailableList() {
        System.out.println("Available Titles are");
        for (Movie m : availableList)
            System.out.println(m);
    }

    public void showCheckOutList() {
        System.out.println("\033[0;35m" + "Check-out Titles are" + "\033[0;30m");
        for (Movie m : checkOutList)
            System.out.println(m);
    }

    public void checkOut(int index) {
        checkOutList.add(availableList.get(index));
        availableList.remove(index);
    }
}

class Movie {
    private String title;
    private int releasedDate;
    private double rating;

    Movie(String title, int year, double rating) {
        this.title = title;
        this.releasedDate = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getReleasedDate() {
        return releasedDate;
    }

    public double getRating() {
        return rating;
    }

    public String toString() {
        return title + "," + releasedDate + "," + rating;
    }
}
