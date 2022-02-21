package com.example.myservlet.web.frontcontroller.v2;

import com.example.myservlet.web.frontcontroller.MyView;
import com.example.myservlet.web.frontcontroller.v1.ControllerV1;
import com.example.myservlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.myservlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.myservlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.example.myservlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.example.myservlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.example.myservlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    //주소를 받으면 객체를 생성하는 hash map(controllerMap) 생성
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    //프론트 컨트롤러를 생성하면 controllerMap에 각 컨트롤러의 주소와 생성을 매핑한다.
    public FrontControllerServletV2(){
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 현재 주소를 가져와서 requestURI 에 저장한다.
        String requestURI = request.getRequestURI();
        //그 주소에 맞는 객체를 생성해서 controller에 저장한다.
        ControllerV2 controller = controllerMap.get(requestURI);
        // 모든 클래스가 ControllerV2 인터페이스의 자식 클래스들이기 때문에 ControllerV2 으로 형변환이 가능하다.

        //만약 주소에 맞는 컨트롤러가 없을시 예외처리
        if(controller == null){
            //NOT_Found 에러 생성
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // (v1)주소에 맞는 컨트롤러가 있다면, 각 객체의 process(로직 메서드)를 실행한다.
        // (v2) process 메서드는 MyView를 리턴하기 때문에 MyView로 받아준다.
        // (v2) 각 컨트롤러의 view는 render 를 사용할 수 있게 된다.
        MyView view = controller.process(request, response);

        // (v2) 추가된 부분
        // 각 컨트롤러의 jsp를 실행한다.(view를 처리한다.)
        view.render(request,response);
    }
}
