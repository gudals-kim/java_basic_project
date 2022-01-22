package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {


        // object-mapper
        // Text Json -> object
        // object -> text Json

        var objectMapper = new ObjectMapper();
        // object -> text
        // object mapper 가 get메소드를 사용한다.
        var user = new User("김형민", 10, "010-1111-2222");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object
        // text가 object로 바뀔때는 디폴트생성자를 필요한다.
        // object mapper를 사용할때, 각 객체의 메소드에 이름에 get이 들어가면 안된다.
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);




    }

}
