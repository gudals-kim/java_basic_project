package com.example.reponse.controller;

import com.example.reponse.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();//var는 타입추론
        user.setName("kimgudals");
        user.setAddress("광주광역시");

        return user;

    }



}
