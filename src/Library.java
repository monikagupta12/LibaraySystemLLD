public class Library {

    public static final int policy=15;
    User librarian;
    Address address;

    BookHandler bookHandler;
    UserHandler userHandler;
    UserLoginService userLoginService;
    IssueBookService issueBookService;
    BookManagementService bookManagementService;
    BookSearchService bookSearchService;


    public Library() {
        this.librarian = null;
        this.address = null;

        bookHandler=new BookHandler();
        userHandler=new UserHandler();

        userLoginService=new UserLoginService();
        bookManagementService=new BookManagementService(bookHandler,userHandler);
        this.issueBookService=new IssueBookService(bookHandler,userHandler);

    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }


    public User getLibrarian() {
        return librarian;
    }

    public UserHandler getUserHandler() {
        return userHandler;
    }

    public void addLibraryAddress(Address address){
        setAddress(address);
    }



//    public String addUser(String name, Address address, String phoneNo){
//        return userLoginService.addUser(new User(name,address,phoneNo),userHandler);
//    }


    public void allBookInLibrary(){
        bookSearchService.allBookInLibrary(bookHandler);
    }

    public void findBookWithAuthorName(String authorName){
        bookSearchService.findBookWithAutherName(bookHandler, authorName);

    }
    public void findBookWithBookName(String bookname){
        bookSearchService.findBookWithBookName(bookHandler,bookname);

    }













}
