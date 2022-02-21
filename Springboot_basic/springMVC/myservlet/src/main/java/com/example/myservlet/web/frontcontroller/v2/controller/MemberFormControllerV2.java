package com.example.myservlet.web.frontcontroller.v2.controller;



import com.example.myservlet.web.frontcontroller.MyView;
import com.example.myservlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        기존 (v1) 코드
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
        //(v2) 에서는 그냥 MyView 객체에 주소를 넣어서 반환하면 된다.
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
