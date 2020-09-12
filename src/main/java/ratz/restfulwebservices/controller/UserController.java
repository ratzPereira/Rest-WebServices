package ratz.restfulwebservices.controller;


import org.springframework.web.bind.annotation.*;
import ratz.restfulwebservices.daoservice.UserDaoService;
import ratz.restfulwebservices.domain.User;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;


    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){

       User savedUser = userDaoService.save(user);

    }
}
