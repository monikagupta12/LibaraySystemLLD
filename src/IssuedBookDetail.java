import java.time.LocalDate;

public class IssuedBookDetail {
    public int bookId;
    public LocalDate issuedDate;

    public IssuedBookDetail(int bookId, LocalDate issuedDate) {
        this.bookId = bookId;
        this.issuedDate = issuedDate;
    }
}
