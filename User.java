package com.example.E_commerce.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Register")
public class User {

    public User(){
        
    }

public User(String email,String password){
    super();
    this.email=email;
    this.password=password;
}

    @Id
    private String email;
    private String password;

    //Getter and Setter
   
    
     
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
}

