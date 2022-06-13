package br.com.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.User;

@RestController
@RequestMapping("/users")
// http://localhost:8080/users
public class UserController {
    
private List<User> users = new ArrayList<User>();

    @GetMapping("/")
    public User user(){

        User user = new User();
        user.setId(1L);
        user.setName("Gui");
        user.setUsername("Guilherme");

        return user;
    }

    @PostMapping("/")
    // Post method to insert new users
    public User user(@RequestBody User user){

        users.add(user);
       return user;
    }

    @GetMapping("/list")
    // Get method to list all users
    public List<User> list(){

        return users;
    }
}
