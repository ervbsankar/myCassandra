package controller;


import Entity.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SampleController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    public String world() {
        return "Hello World: Sankar!";
    }

    @RequestMapping("/greeting")
    public List<User> getInfo(){
        System.out.println(userDao.findByName());
        System.out.println(userDao.countUsers());
        return userDao.findByName();
    }

}
