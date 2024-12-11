package com.example.E_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.E_commerce.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
