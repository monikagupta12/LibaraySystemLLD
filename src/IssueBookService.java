import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class IssueBookService {
    BookHandler bookHandler;
    UserHandler userHandler;

    public IssueBookService(BookHandler bookHandler, UserHandler userHandler) {
        this.bookHandler = bookHandler;
        this.userHandler = userHandler;
    }

    public void issuedBook(int bookId, String userId) {
        Book book = bookHandler.findBookwithBookId(bookId);
        BookMetaData bookMetaData = bookHandler.getBookMetaData(book.getIsbn());
        User person = checkRegisterUser(userId, userHandler);
        if (bookMetaData.availableCopies == 0) {
            bookMetaData.getWaitingQueue().add(userHandler.getUser(userId));
            System.out.println("sorry book not available and yor are in waiting");
        } else {
            bookMetaData.availableCopies--;
            IssuedBookDetail issuedBookDetail = new IssuedBookDetail(bookId, LocalDate.now());
            person.getIssuedBookDetails().add(issuedBookDetail);
            bookHandler.addIssuedUserDetailsInLibrary(bookId, person);
            System.out.println("book issued");
        }
    }

    public void submitBook(int bookId, String userId){
        Book book=bookHandler.findBookwithBookId(bookId);
        if(book==null){
            throw  new RuntimeException("this book not in library");
        }
        User person=checkRegisterUser(userId,userHandler);
        List<IssuedBookDetail> issuedBookDetails=person.getIssuedBookDetails();
        IssuedBookDetail issuedBookDetail=checktimevalidation(book, issuedBookDetails);
        BookMetaData bookMetaData=bookHandler.getBookMetaData(book.getIsbn());
        bookMetaData.availableCopies++;
        if(bookMetaData.getWaitingQueue().size()!=0){
            issuedBookDetails.remove(issuedBookDetail);
            bookHandler.removeIssuedBookUserDetails(bookId);
            User user=bookMetaData.getWaitingQueue().remove();
            issuedBook(bookId,user.getPhoneNo());
        }
        else{
            issuedBookDetails.remove(issuedBookDetail);
            bookHandler.removeIssuedBookUserDetails(bookId);
        }

    }

    private IssuedBookDetail checktimevalidation(Book book, List<IssuedBookDetail>issuedBookDetails) {
        for(IssuedBookDetail issuedBookDetail:issuedBookDetails){
            if(book.getBookId()==issuedBookDetail.bookId){
                LocalDate issuedDate=issuedBookDetail.issuedDate;
                LocalDate currentDate=LocalDate.now();
                long days= ChronoUnit.DAYS.between(issuedDate,currentDate);
                if(days>15){
                    long fine=(days-15)*1;
                    System.out.println("pay fine amount due to late submission"+fine);
                }
                return issuedBookDetail;

            }
        }
        throw  new RuntimeException("user not issued this book");
    }


    private User checkRegisterUser(String userId, UserHandler userHandler) {
        User person=userHandler.getUser(userId);
        if(person==null){
            throw new RuntimeException("this is not register user");
        }
        return person;
    }
}


//    public void reIssuedBook(int bookId){
//        Book book=library.findBookwithBookId(bookId);
//        LocalDate issuedDate=book.getIssuedDate();
//        LocalDate currentDate=LocalDate.now();
//        long days= ChronoUnit.DAYS.between(issuedDate,currentDate);
//       if(days>library.policy){
//           long fine=(days-library.policy)*1;
//           System.out.println("pay fine amount due to late submission"+fine);
//       }
//        book.setIssuedDate(LocalDate.now());
//
//    }

