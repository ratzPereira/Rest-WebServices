package ratz.restfulwebservices.daoservice;


import org.springframework.stereotype.Component;
import ratz.restfulwebservices.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> users = new ArrayList<>();
    public static int usersCount = 3;

    static {
        users.add(new User(1,"Ratz", new Date()));
        users.add(new User(2,"Carol", new Date()));
        users.add(new User(3,"Nasus", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user:users) {
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
}
