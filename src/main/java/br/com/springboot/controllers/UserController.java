package br.com.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){

       Optional<User> userId = users.stream().filter(user -> user.getId() == id).findFirst();
        
       if(userId.isPresent()){
        return userId.get();
       }
        return null;
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

    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteOrder(@PathVariable(value = "id") Long id) {
         // Access the DB and delete the order
         return true;
    }
}
