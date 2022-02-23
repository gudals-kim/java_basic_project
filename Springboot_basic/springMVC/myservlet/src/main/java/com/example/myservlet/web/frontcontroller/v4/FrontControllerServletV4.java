package com.example.myservlet.web.frontcontroller.v4;

import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.MyView;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    //주소를 받으면 객체를 생성하는 hash map(controllerMap) 생성
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    //프론트 컨트롤러를 생성하면 controllerMap에 각 컨트롤러의 주소와 생성을 매핑한다.
    public FrontControllerServletV4(){
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 현재 주소를 가져와서 requestURI 에 저장한다.
        String requestURI = request.getRequestURI();
        //그 주소에 맞는 객체를 생성해서 controller에 저장한다.
        ControllerV4 controller = controllerMap.get(requestURI);



        //만약 주소에 맞는 컨트롤러가 없을시 예외처리
        if(controller == null){
            //NOT_Found 에러 생성
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // (v1)주소에 맞는 컨트롤러가 있다면, 각 객체의 process(로직 메서드)를 실행한다.
        // (v2) process 메서드는 MyView를 리턴하기 때문에 MyView로 받아준다.
        // (v2) 각 컨트롤러의 view는 render 를 사용할 수 있게 된다.
//        MyView view = controller.process(request, response);

//        (v3) createParamMap 메서드로 request에 담겨져있는 파라미터 정보를 paramMap에 가져온다.
        Map<String, String > paramMap = createParamMap(request);
//        (v4) 모델 객체를 프론트 컨트롤러에서 생성해서 넘겨줘야한다.
//        (v4) 각 컨트롤러에서 모델에 데이터를 담으면 여기에 담겨져있다.
        HashMap<String, Object> model = new HashMap<>();

//        (v3) 가져온 paramMap을 각 객체의 매개변수로 주어 각 컨트롤러의 ModelView 객체를 가져온다.
//        ModelView mv = controller.process(paramMap);
//        (v4) 각 컨트롤러의 논리주소가 viewName에 저장된다.
        String viewName = controller.process(paramMap, model);

//        (v2) 추가된 부분
//        각 컨트롤러의 jsp를 실행한다.(view를 처리한다.)
//        view.render(request,response);

//        (v3) 에서는 getViewName을 하면 논리 주소만 가져온다.
//        String viewName = mv.getViewName();

//        (v3) 그래서 viewResolver 라는 메서드로 물리 주소로 변환시켜준다.
        MyView view = viewResolver(viewName);

//        (v3) render 에서는 model 정보를 매개변수로 받아준다.
//        자세한 설명은 MyView의 render 메서드에 주석 참고
//        view.render(mv.getModel(), request, response);
        view.render(model,request,response);
    }
//    (v3) createParamMap 주석 start
//    request 객체에 있는 것을 paramMap에 넘겨주는 메서드
//    key 는 request 객체에 있는 paramName이 되고,
//    request 객체의 paramName의 velue가 paramMap의 velue가 된다.
//    (v3) createPramMap 주석 end
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(
                                paramName, request.getParameter(paramName)
                        )
                );
        return paramMap;
    }
    //    (v3) viewResolver 주석 start
//    논리주소를 매개변수로받아 물리주소로 변환시켜준다.
//    viewResolver 주석 end
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
