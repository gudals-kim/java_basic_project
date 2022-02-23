package com.example.myservlet.web.frontcontroller.v4.controller;

import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

//        기존 (v1) 코드
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);

//        (v2) 에서는 그냥 MyView 객체에 주소를 넣어서 반환하면 된다.
//        return new MyView("/WEB-INF/views/new-form.jsp");
//        (v3) 에서는 "new-form" 이라는 논리 주소만 modelView로 반환해준다.
//        return new ModelView("new-form");
//        (v4) 논리 이름만 반환한다.
        return "new-form";
    }
}
