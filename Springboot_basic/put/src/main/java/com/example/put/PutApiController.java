package com.example.put;


import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @RequestMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }
    @RequestMapping("/put/{userId}")
    public PostRequestDto putval(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        return requestDto;
    }
}
