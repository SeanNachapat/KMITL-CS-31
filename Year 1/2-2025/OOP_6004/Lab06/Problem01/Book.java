public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected int year;
    protected int numberOfPage;
    private int currentPageNumber;

    public Book(String title, String author, String pub, int yr, int numberOfPage) {
        this.title = title;
        this.author = author;
        this.publisher = pub;
        this.year = yr;
        this.numberOfPage = numberOfPage;
    }

    public void turnPageFoward() {
        currentPageNumber++;
    }

    public void turnPageBackward() {
        currentPageNumber--;
    }

    public int nowAtPage() {
        return currentPageNumber;
    }

    public String getTitle() {
        return title;
    }
}