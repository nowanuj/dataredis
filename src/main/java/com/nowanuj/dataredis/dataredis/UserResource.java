package com.nowanuj.dataredis.dataredis;

import com.nowanuj.dataredis.dataredis.model.User;
import com.nowanuj.dataredis.dataredis.respo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis/usr")
public class UserResource {


    @Autowired
    private UserRepo userRepo;

    /*public UserResource(UserRepo userRepo) {
        this.userRepo = userRepo;
    }*/

    @GetMapping("/add/{id}/{name}")
    public User addUser(@PathVariable("id") final String id, @PathVariable("name") final  String name){
        userRepo.save(new User(id, name, 2000L));
        return userRepo.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User updateUser(@PathVariable("id") final String id, @PathVariable("name") final  String name){
        userRepo.save(new User(id, name, 1000L));
        return userRepo.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> deleteUser(@PathVariable("id") final String id){
        userRepo.delete(id);
        return userRepo.findAll();
    }

    @GetMapping("/all")
    public Map<String, User> findAllUsers(){
        return userRepo.findAll();
    }

}
