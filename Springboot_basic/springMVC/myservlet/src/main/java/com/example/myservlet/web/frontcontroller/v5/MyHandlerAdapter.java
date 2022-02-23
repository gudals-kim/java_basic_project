package com.example.myservlet.web.frontcontroller.v5;

import com.example.myservlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
//    (v5) handler 는 컨트롤러이다.
//    (v5) 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
//    (v5) 핸들러에 들어간 컨트롤러가 해당하는 어댑터에 들어가면 True 아니면 False 반환
    boolean supports(Object handler);
//    (v5) 어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환한다.
//    (v5) 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도 반환한다.
//    (v5) v4 까지는 프론터 컨트롤러가 각 컨트롤러를 호출했지만 v5 부터는 이 어댑터가 각 컨트롤러들을 호출한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
