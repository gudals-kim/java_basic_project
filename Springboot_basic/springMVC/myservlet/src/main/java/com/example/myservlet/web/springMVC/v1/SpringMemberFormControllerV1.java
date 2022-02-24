package com.example.myservlet.web.springMVC.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//(v1) Controller 애노테이션의 기능
//1. 현재 클래스를 자동으로 스프링 빈에 등록한다.
//2. 스프링 MVC에서 컨트롤러로 인식한다.
@Controller
public class SpringMemberFormControllerV1 {
//    (v1) RequestMapping 은 요청정보를 매핑한다. 해당 (URL)이 호출되면 이 메서드가 호출된다.
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
//        (v1) 모델과 뷰 정보를 modelAndView 객체에 담아서 리턴하면 된다.
        return new ModelAndView("new-form");
    }
}
