import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        demo2();
    }

    static void demo1() { // main()
        HashMap<Integer, Book> allBooks = new HashMap<>();
        allBooks.put(1, new LibraryBook(1, "Charlotte's Web", "EB White", "abc", 1952, 100, PrintType.PRINT));
        allBooks.put(2, new LibraryBook(2, "Charlotte's Web", "EB White", "abc", 1952, 100, PrintType.ECOPY));
        allBooks.put(3, new LibraryBook(3, "The BFG", "Roald Dahl", "abc", 1982, 300, PrintType.PRINT));
        allBooks.put(4,
                new LibraryBook(4, "The Little Prince", "Antoine de Saint-Exupéry", "abc", 1943, 200, PrintType.ECOPY));
        allBooks.put(5, new ArchiveMaterial(5, "My Mister", "not KBS", "abc", 2018, 400, Status.READY));
        allBooks.put(6, new ArchiveMaterial(6, "Sword Snow Stride", "CNTV", "abc", 2018, 500, Status.REPAIRED));
        for (Book b : allBooks.values()) {
            System.out.println(b);
        }
    }

    static void demo2() { // main()
        Library lib = new Library();
        Book b1 = lib.getBookById(1);
        Book b2 = lib.getBookById(2);
        Book b3 = lib.getBookById(3);
        Book b4 = lib.getBookById(4);
        Book b5 = lib.getBookById(5);
        Book b6 = lib.getBookById(6);
        System.out.println(lib.checkOut(b2, 0, 0, 0)); // ecopy
        System.out.println(lib.checkOut(b5, 0, 0, 0)); // archive
        lib.checkIn(b1, 0, 0, 0); // still in lib
        System.out.println(lib.checkOut(b1, 2023, 10, 25)); // ok
        System.out.println(lib.checkOut(b1, 2023, 10, 26)); // not available
        lib.checkIn(b1, 2023, 11, 16);
        System.out.println(lib.checkOut(b3, 2023, 10, 27)); // ok
        lib.checkIn(b3, 2023, 10, 29);
    }
}