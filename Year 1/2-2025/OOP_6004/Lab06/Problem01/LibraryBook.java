import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryBook extends Book implements BorrowAble {
    private int id;
    private Boolean availForBorrow = true;
    private LocalDate dateBorrow;
    private PrintType pt;

    public LibraryBook(int id, String title, String author, String pub, int yr, int numberOfPage, PrintType pt) {
        super(title, author, pub, yr, numberOfPage);
        this.id = id;
        this.pt = pt;
    }

    public void setBookAvailableFalse() {
        availForBorrow = false;
    }

    public void setBookAvailableTrue() {
        availForBorrow = true;
    }

    public boolean isAvailable() {
        return availForBorrow;
    }

    @Override
    public boolean checkoutItem(int yy, int mm, int dd) {
        if (pt == PrintType.PRINT && this.availForBorrow) {
            this.availForBorrow = false;
            this.dateBorrow = LocalDate.of(yy, mm, dd);
            return true;
        } else {
            return false;
        }
    }

    public int returnItem(int yy, int mm, int dd) {
        if (!this.availForBorrow) {
            this.availForBorrow = true;
            LocalDate returnDate = LocalDate.of(yy, mm, dd);
            long daysBetween = ChronoUnit.DAYS.between(dateBorrow, returnDate);

            if (daysBetween > 7) {
                return (int) daysBetween - 7;
            }
        }
        return 0;
    }

    public String toString() {
        return "LibraryBook [" +
                "id=" + id +
                ", title=" + title +
                ", type=" + pt +
                ", avail=" + availForBorrow +
                ']';
    }
}
