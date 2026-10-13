import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library=new Library();

      //  library.appointLibrarian(new User("charli",new Address("Delhi"),"98786"));
        library.allBookInLibrary();

        System.out.println("----------------------------");

        library.allBookInLibrary();

        Scanner scanner=new Scanner(System.in);
        System.out.println("enter book id for issue book");
        int id1= scanner.nextInt();
        System.out.println("enter userid");
        String userid= scanner.next();

        library.issueBookService.issuedBook(id1,userid);
        System.out.println("----------");
        System.out.println("enter book id for submit book");
        int id2= scanner.nextInt();
        library.issueBookService.submitBook(id2,userid);
        System.out.println("-----------------------");
        library.issueBookService.issuedBook(id1,userid);




    }
}