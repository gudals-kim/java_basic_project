package com.example.myservlet.web.frontcontroller.v2;

import com.example.myservlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    //(v2)void -> MyView 로 반환하게 만듦
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
