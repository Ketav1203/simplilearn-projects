package com.simplilearn.kitchenStoryFoods.service;

import com.simplilearn.kitchenStoryFoods.models.Users;
import com.simplilearn.kitchenStoryFoods.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }


    public void saveUser(Users user) {

        userRepository.save(user);
    }

    public Users getUserDetailByEmail(String email) {

        return userRepository.getByEmail(email);
    }

    public List<Users> findAllUsersOrderByName() {

        return userRepository.findUsersOrderByName();
    }

    public Users findUserById(int userId) {

        return userRepository.findById(userId).orElse(new Users());
    }
}
