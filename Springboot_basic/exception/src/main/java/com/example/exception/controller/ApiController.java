package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {
    @GetMapping("")//require = false 이면 ?name=1234 이런 값이 없어도 오류가 안나고 실행 될수 있게 함
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;

        return user;
    }
    @PostMapping("/post")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }

}
