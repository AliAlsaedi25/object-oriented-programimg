import java.util.*;

public class Server
{
    Map<String, ISub> users = new HashMap<String, ISub>();

    public void display(String name, String message){
        for (ISub user : users.values()){
            user.notify(name,message);
        }
    }

    public void subscribe (String code, ISub room){

        users.put(code, room);
    }

    public void unsubscribe (String code, ISub user){
        users.remove(code, user);
    }

}
//done
