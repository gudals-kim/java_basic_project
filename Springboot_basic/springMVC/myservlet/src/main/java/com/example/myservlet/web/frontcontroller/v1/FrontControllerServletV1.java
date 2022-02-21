package com.example.myservlet.web.frontcontroller.v1;

import com.example.myservlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.myservlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.myservlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    //주소를 받으면 객체를 생성하는 hash map(controllerMap) 생성
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //프론트 컨트롤러를 생성하면 controllerMap에 각 컨트롤러의 주소와 생성을 매핑한다.
    public FrontControllerServletV1(){
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 현재 주소를 가져와서 requestURI 에 저장한다.
        String requestURI = request.getRequestURI();
        //그 주소에 맞는 객체를 생성해서 controller에 저장한다.
        ControllerV1 controller = controllerMap.get(requestURI);
        // 모든 클래스가 ControllerV1 인터페이스의 자식 클래스들이기 때문에 ControllerV1 으로 형변환이 가능하다.

        //만약 주소에 맞는 컨트롤러가 없을시 예외처리
        if(controller == null){
            //NOT_Found 에러 생성
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 주소에 맞는 컨트롤러가 있다면, 각 객체의 process(로직 메서드)를 실행한다.
        controller.process(request, response);
    }
}
