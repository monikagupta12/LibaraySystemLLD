
import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private static int i=0;
    public static final int capacity=50;
    private int currentBookInSelf;
    private int selfId;
    private String genres;
    private List<Book> bookList;

    public Shelf(String genres) {
        selfId=idGenrator();
        this.genres = genres;
        bookList=new ArrayList<>();
        currentBookInSelf=0;
    }

    public int getCurrentBookInSelf() {
        return currentBookInSelf;
    }

    public void setCurrentBookInSelf(int currentBookInSelf) {
        this.currentBookInSelf = currentBookInSelf;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Shelf.i = i;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBookInSelf(Book book) {
        bookList.add(book);
    }
    public boolean removeBookInSelf(Book book1){
        for (Book book:bookList){
            if (book.getBookId()==book1.getBookId()){
                bookList.remove(book);
                currentBookInSelf--;
                return true;
            }
        }
        return false;
    }
    public List<Book> showAllBookInSelfGenres(Shelf shelf){
        List<Book> avaliableBook=new ArrayList<>();
        for (Book book:bookList){
            if (book.getGenres().equalsIgnoreCase(shelf.getGenres())){
                avaliableBook.add(book);
            }
        }
        return avaliableBook;
    }

    public boolean findBookedWithBookId(int bookId) {
        for (Book  book:bookList){
            if (book.getBookId()==bookId){
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }
    public boolean findSelfHavingSpace(Book book){
        if(bookList.size()<capacity){
            bookList.add(book);
            return true;
        }
        return false;
    }

    public boolean addNewBook(Book book){
        if(currentBookInSelf<capacity){
            bookList.add(book);
            currentBookInSelf++;
            return true;
        }
        return false;
    }
    private synchronized int idGenrator() {
        i++;
        return i;
    }

}
