package com.example.post.controller;


import com.example.post.controller.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String ,Object> requestData){//map과 randa로 받기

        requestData.forEach((key, value) -> {
            System.out.println("key :" + key);
            System.out.println("value :" + value);
        });

    }

    @PostMapping("/post-object")
    public void postObject(@RequestBody PostRequestDto postRequestDto){
        System.out.println(postRequestDto.toString());

    }


}
