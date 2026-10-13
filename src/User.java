import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private String userName;
    private Address userAddress;
    private List<IssuedBookDetail> issuedBookDetails;
    private String phoneNo;

    public User(String userName, Address userAddress,String phoneNo) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.phoneNo=phoneNo;
        issuedBookDetails =new ArrayList<>();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public List<IssuedBookDetail> getIssuedBookDetails() {
        return issuedBookDetails;
    }

    public void notifyByLibrary(String message) {
        System.out.println(message);
    }

    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
