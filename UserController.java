package com.example.E_commerce.Controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.E_commerce.Model.User;
import com.example.E_commerce.Request.LoginRequest;
import com.example.E_commerce.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
     private UserService userService;

    @PostMapping("/register")
     public String registerUser(@RequestBody User user ){
           userService.addUser(user);
           return "User registered successfully!";
     }

     @PostMapping("/login")
     public ResponseEntity<?> loginUser (@RequestBody LoginRequest loginRequest) {

    Optional<User> user = userService.findByEmail(loginRequest.getEmail());

    if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {

        return ResponseEntity.ok(user.get().getEmail()); // Return email on successful login

    } else {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password!");

    }

}
}
