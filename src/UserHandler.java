import java.util.HashMap;
import java.util.Map;

public class UserHandler {
    private Map<String,User>userRecode;
    UserHandler(){
        userRecode=new HashMap<>();
    }
    public User getUser(String userId){
        if(userRecode.containsKey(userId)){
            return userRecode.get(userId);
        }
        throw new RuntimeException("user with this phoneNo not exit");
    }
    public void addUser(User user){
        if(!userRecode.containsKey(user.getPhoneNo())){
            userRecode.put(user.getPhoneNo(), user);
            return;
        }
        throw new RuntimeException("user with this phoneNo exit");
    }
    public boolean userExit(String userId){
        return userRecode.containsKey(userId);
    }
}
