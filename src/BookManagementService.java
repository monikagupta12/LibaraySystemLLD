import java.util.Queue;

public class BookManagementService {
    BookHandler bookHandler;
    UserHandler userHandler;
    Notification notification;

    public BookManagementService(BookHandler bookHandler, UserHandler userHandler) {
        this.bookHandler = bookHandler;
        this.userHandler = userHandler;
        notification=new Notification();
    }


//    public String appointLibrarian(User newUser) {
//        if(!userHandler.userExit(newUser.getPhoneNo())){
//            userHandler.addUser(newUser);
//        }
////        userHandler.addUser(newUser);
//        this.librarian =newUser;
//        return newUser.getPhoneNo();
//    }

    public int addBook(Book book){
        BookMetaData bookMetaData=bookHandler.getBookMetaData(book.getIsbn());
        if(bookMetaData==null){
            bookMetaData=new BookMetaData(book.getIsbn());
            bookHandler.addNewBookMetaData(bookMetaData);
            bookHandler.addBookInLibeary(book);
            bookHandler.addNewBookMetaData(bookMetaData);
        }
        else {
            bookMetaData.availableCopies++;
            bookMetaData.totalCopies++;
            bookHandler.addBookInLibeary(book);
        }
        return book.getBookId();
    }

    public void removeBook(int bookId){
        Book book= bookHandler.findBookwithBookId(bookId);
        if(book==null){
            throw new RuntimeException("book is not present in library");
        }
        bookHandler.romoveBookInLibrary(bookId);
        BookMetaData bookMetaData=bookHandler.getBookMetaData(book.getIsbn());
        bookMetaData.availableCopies--;
        bookMetaData.totalCopies--;
        if(bookMetaData.totalCopies==0){
            bookHandler.removeBookMetaData(book.getIsbn());
            Queue<User> queue=bookMetaData.getWaitingQueue();
            notifyAllUser(queue,"book removed from Library",userHandler);
            System.out.println("book removed successfully");
        }
//        throw new RuntimeException("book not in library");
    }

    private void notifyAllUser(Queue<User> queue, String message,UserHandler userHandler) {
        for (User user: queue){
            user.notify(message);
        }
    }
}
