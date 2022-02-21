package com.example.myservlet.web.frontcontroller.v3.controller;



import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.MyView;
import com.example.myservlet.web.frontcontroller.v2.ControllerV2;
import com.example.myservlet.web.frontcontroller.v3.ControllerV3;
import org.springframework.boot.Banner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
//        기존 (v1) 코드
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
        //(v2) 에서는 그냥 MyView 객체에 주소를 넣어서 반환하면 된다.
//        return new MyView("/WEB-INF/views/new-form.jsp");

//        (v3) 에서는 "new-form" 이라는 논리 주소만 modelView로 반환해준다.
        return new ModelView("new-form");
    }
}
