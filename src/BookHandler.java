import java.util.HashMap;
import java.util.Map;

public class BookHandler {
    private Map<Integer,Book> bookRecord;
    private Map<String,BookMetaData>bookCount;
    private Map<Integer ,User> issuedBookMap;

    public BookHandler() {
        this.bookRecord = new HashMap<>();
        this.bookCount=new HashMap<>();
        this.issuedBookMap=new HashMap<>();
    }

    public Map<String, BookMetaData> getBookCount() {
        return bookCount;
    }

    public Map<Integer, Book> getBookRecord() {
        return bookRecord;
    }
    public void addBookInLibeary(Book book){
        bookRecord.put(book.getBookId(),book);
    }

    public Book findBookwithBookId(int bookId) {
        return bookRecord.getOrDefault(bookId,null);
    }

    public void romoveBookInLibrary(int bookId) {
        bookCount.remove(bookId);
    }


    public BookMetaData  getBookMetaData(String insNo){
        return bookCount.getOrDefault(insNo,null);
    }
    public void addNewBookMetaData(BookMetaData bookMetaData) {
        bookCount.put(bookMetaData.getInsNo(),bookMetaData);
    }

    public void removeBookMetaData(String insNo) {
        bookCount.remove(insNo);
    }

    public void addpersonInWatingList(String insNo, User user) {
        bookCount.get(insNo).getWaitingQueue().add(user);

    }

    public void addIssuedUserDetailsInLibrary(int bookId, User person) {
        issuedBookMap.put(bookId,person);
    }

    public void removeIssuedBookUserDetails(int bookId) {
        issuedBookMap.remove(bookId);
    }
}
