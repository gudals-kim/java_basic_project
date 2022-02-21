package com.example.myservlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    //(v2) 주소를 받는 viewPath
    private String viewPath;
    //(v2) 생성자
    public MyView(String viewPath){
        this.viewPath = viewPath;
    }
    //(v2) render 메서드 생성 JSP 를 실행하는 역할
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
//    (v3) render 메서드 주석 start
//    기존 v2에서는 request 객체에 담아져 있기때문에 바로 dispatcher로 forward를 하면 되지만
//    v3에서는 model이라는 string, object 제너릭의 형태로 담아져 있기 때문에 forward를 해주려면
//    다시 request객체의 attribute로 넣어줘야한다. <- modelToRequestAttribute 메서드
//    그런 과정을 하는 메서드이다.
//    render 메서드 주석 end
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
//    (v3) model 객체에서 attribute 객체로 넘겨주는 메서드
    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value)-> request.setAttribute(key, value));
    }
}
