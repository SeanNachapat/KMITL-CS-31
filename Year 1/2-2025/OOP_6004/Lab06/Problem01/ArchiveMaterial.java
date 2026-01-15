public class ArchiveMaterial extends Book {
    private int id;
    private Status st;

    ArchiveMaterial(int id, String title, String author, String pub, int yr, int numberOfPage, Status st) {
        super(title, author, pub, yr, numberOfPage);
        this.id = id;
        this.st = st;
    }

    @Override
    public String toString() {
        return "LibraryBook [" +
                "id=" + id +
                ", title=" + title +
                ", status=" + st +
                ", message=" + st.sayHi() +
                ']';
    }
}
