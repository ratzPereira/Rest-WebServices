package ratz.restfulwebservices.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ratz.restfulwebservices.daoservice.UserDaoService;
import ratz.restfulwebservices.domain.User;
import ratz.restfulwebservices.exception.UserNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;


    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id- " + id);
        }

        return user;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {

        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        //return 201 status code
        ResponseEntity.created(location).build();

    }
}
