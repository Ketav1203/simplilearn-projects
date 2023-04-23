package com.simplilearn.kitchenStoryFoods.RestControllers;

import com.simplilearn.kitchenStoryFoods.models.Users;
import com.simplilearn.kitchenStoryFoods.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestDataFetch {

    @Autowired
    UserRepository userRepository;



    @GetMapping("AllUsers/information")
    public List<Users> getAllRegisteredUsers(){

        return userRepository.findAll();

    }
}
