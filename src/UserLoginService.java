public class UserLoginService {
    public String addUser(User user, UserHandler userHandler){
        userHandler.addUser(user);
        return user.getPhoneNo();
    }
}
