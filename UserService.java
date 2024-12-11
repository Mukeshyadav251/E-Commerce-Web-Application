package com.example.E_commerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.E_commerce.Model.User;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Request.LoginRequest;

@Service
public class UserService {

@Autowired
UserRepository userRepository;

public User addUser(User user){
    return userRepository .save(user);
}

public Boolean loginUser(@RequestBody LoginRequest loginRequest){
            Optional<User> user= userRepository.findById(loginRequest.getEmail());

            if(user.isEmpty()){
                return false;
            }
                       User user1= user.get();
                      return  user1.getPassword().equals(loginRequest.getPassword());
                       
}
public Optional<User> findByEmail(String email) {
    return userRepository.findById(email);

}
}
