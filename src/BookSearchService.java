public class BookSearchService {
    public void allBookInLibrary(BookHandler bookHandler){
        for (String insNo:bookHandler.getBookCount().keySet()){
            Book book=findBookwithINSNumber(bookHandler,insNo);
            BookMetaData bookMetaData=bookHandler.getBookMetaData(insNo);
            printBookDetails(book,bookMetaData);
        }
    }

    public Book findBookwithINSNumber(BookHandler bookHandler,String insNo){
        for (int bookId:bookHandler.getBookRecord().keySet()){
            Book book=bookHandler.getBookRecord().get(bookId);
            if (book.getIsbn().equalsIgnoreCase(insNo)){
                return book;
            }
        }
        throw new RuntimeException("Book no available in library");

    }

    public void findBookWithAutherName(BookHandler bookHandler,String authoreName){
        for (int bookId:bookHandler.getBookRecord().keySet()){
            Book book=bookHandler.getBookRecord().get(bookId);
            if (book.getAuthor().equalsIgnoreCase(authoreName)){
                String insNo=book.getIsbn();
                BookMetaData bookMetaData=bookHandler.getBookMetaData(insNo);
                printBookDetails(book,bookMetaData);
            }
        }
        throw new RuntimeException("Book no available in library");
    }
    public void findBookWithBookName(BookHandler bookHandler,String bookname){
        for (int bookId:bookHandler.getBookRecord().keySet()){
            Book book=bookHandler.getBookRecord().get(bookId);
            if (book.getName().equalsIgnoreCase(bookname)){
                String insNo=book.getIsbn();
                BookMetaData bookMetaData=bookHandler.getBookMetaData(insNo);
                printBookDetails(book,bookMetaData);
            }
        }
        throw new RuntimeException("Book no available in library");
    }

    public Book findBookwithBookId(BookHandler bookHandler,int bookId) {
        Book book=bookHandler.getBookRecord().getOrDefault(bookId,null);
        if(book==null){
            throw new RuntimeException("book with this id not exit");
        }
        return book;

    }

    private void printBookDetails(Book book, BookMetaData bookMetaData){
        System.out.println("BookName="+book.getName());
        System.out.println(" Authroe="+book.getAuthor());
        System.out.println("BookINSNumber="+bookMetaData.getInsNo());
        if(bookMetaData.availableCopies ==0){
            System.out.println("isAvailable=false");
        }
        else{
            System.out.println("isAvailable=true");
        }
        System.out.println("---------");

    }
}
