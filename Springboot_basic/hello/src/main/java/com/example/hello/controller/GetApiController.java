package com.example.hello.controller;



import com.example.hello.controller.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello") //-> http://localhost:8080/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get으로 http://localhost:8080/api/get/hi 예전 문법 방식
    public String hi(){
        return "hi";
    }


    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")//변화하는 값일때 계속 주소를 못넣으니 괄호를 넣어주고 변화값을 넣는다.
    public String pathVariable(@PathVariable String name){//name을
        System.out.println("pathVariable : "+name);
        return name;
    }
    // ?key = value & key2 = value2

    //http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){//Map과 람다식 사용 데이터가 무엇이 들어올지 모를때

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }
    //직접지정 방식
    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,//key 값들
            @RequestParam int age,
            @RequestParam String email
    ){//사용 데이터를 명확하게 알 때
        System.out.println(name);
        System.out.println(age);
        System.out.println(email);


        return name+" "+age+" "+email;
    }
    //변수가 많아질때는? -> 객체로 넘기기
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){//RequestParam을 붙이지 않음

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getAge());
        System.out.println(userRequest.getEmail());

        return userRequest.toString();
    }


}
