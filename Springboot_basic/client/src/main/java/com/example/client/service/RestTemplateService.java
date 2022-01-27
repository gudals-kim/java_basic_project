package com.example.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {


    // response 응답을 받아올거임
    public String hello(){
        URI uri = UriComponentsBuilder // http://localhost/api/server/hello 주소생성
                .fromUriString("http://localhost")  //http://localhost에 생성
                .path("/api/server/hello")//경로 지정
                .encode()// 인코딩 옵션
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }
}
