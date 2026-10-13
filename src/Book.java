public class Book implements Suscribe {
    private static int i=0;
    private int bookId;
    private String name;
    private String author;
    private String genres;
    private String isbn;

    public Book( String name, String author, String genres, String isbn)  {
        this.bookId = idGenrator();
        this.name = name;
        this.author = author;
        this.genres = genres;
        this.isbn =isbn;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static int getI() {
        return i;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }



    private synchronized int idGenrator() {
        i++;
        return i;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genres='" + genres + '\'' +
                ", insNo='" + isbn + '\'' +
                '}';
    }

    @Override
    public void sendNotification(String message) {

    }
}
