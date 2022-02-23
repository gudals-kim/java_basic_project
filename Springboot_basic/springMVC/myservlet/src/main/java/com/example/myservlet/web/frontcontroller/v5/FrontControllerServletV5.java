package com.example.myservlet.web.frontcontroller.v5;

import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.MyView;
import com.example.myservlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.myservlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.myservlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.example.myservlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import com.example.myservlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import com.example.myservlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
//    (v1~v4)주소를 받으면 객체를 생성하는 hash map(controllerMap) 생성
//    private Map<String, ControllerV5> controllerMap = new HashMap<>();
//    (v5) 기존의 controllerMap과 같은 역할을 한다.
//    (v5) 기존에는 맞는 controller를 지정해주었지만 v5에는 모든 컨트롤러를 지원해야함으로 Object을 넣는다.
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
//    (v5) 각 어댑터를 담을 수 있는 리스트
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();


    public FrontControllerServletV5(){
//        (v1~v4) 프론트 컨트롤러를 생성하면 controllerMap에 각 컨트롤러의 주소와 생성을 매핑한다.
//        controllerMap.put("/front-controller/v5/members/new-form", new MemberFormControllerV5());
//        controllerMap.put("/front-controller/v5/members/save", new MemberSaveControllerV5());
//        controllerMap.put("/front-controller/v5/members", new MemberListControllerV5());
        //각 컨트롤러 생성 및 매핑
        initHandlerMappingMap();
        //어댑터 생성 및 매핑
        initHandlerAdapters();
    }
//    (v5) 각 컨트롤러 매핑
    private void initHandlerMappingMap() {
//        (v5) v3 컨트롤러 추가
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
//        (v5) v4 컨트롤러 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }
//    (v5) 각 어댑터 매핑
    private void initHandlerAdapters() {
//        (v5) v3 어댑터 추가
        handlerAdapters.add(new ControllerV3HandlerAdapter());
//        (v5) v4 어댑터 추가
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         (v1~v4)현재 주소를 가져와서 requestURI 에 저장한다.
//        String requestURI = request.getRequestURI();
//        (v1~v4)그 주소에 맞는 객체를 생성해서 controller에 저장한다.
//        ControllerV5 controller = controllerMap.get(requestURI);
//        (v5)에서는 메서드화 했다.
        Object handler = getHandler(request);

//        만약 주소에 맞는 컨트롤러가 없을시 예외처리
//        (v1~v4)if(controller == null){
//        (v5) 컨트롤러에서 핸들러로 변수명 교체
        if(handler == null){
//            NOT_Found 에러 생성
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
//         (v5) 핸들러 어댑터 목록에서 컨트롤러에 맞는 어댑터를 찾는다
        MyHandlerAdapter adapter = getHandlerAdapter(handler);

//         (v1)주소에 맞는 컨트롤러가 있다면, 각 객체의 process(로직 메서드)를 실행한다.
//         (v2) process 메서드는 MyView를 리턴하기 때문에 MyView로 받아준다.
//         (v2) 각 컨트롤러의 view는 render 를 사용할 수 있게 된다.
//        MyView view = controller.process(request, response);

//        (v3) createParamMap 메서드로 request에 담겨져있는 파라미터 정보를 paramMap에 가져온다.
//        Map<String, String > paramMap = createParamMap(request);
//        (v4) 모델 객체를 프론트 컨트롤러에서 생성해서 넘겨줘야한다.
//        (v4) 각 컨트롤러에서 모델에 데이터를 담으면 여기에 담겨져있다.
//        HashMap<String, Object> model = new HashMap<>();

//        (v3) 가져온 paramMap을 각 객체의 매개변수로 주어 각 컨트롤러의 ModelView 객체를 가져온다.
//        ModelView mv = controller.process(paramMap);
//        (v4) 각 컨트롤러의 논리주소가 viewName에 저장된다.
//        String viewName = controller.process(paramMap, model);
//         (v5) 어댑터를 호출해서 mv를 받아온다.
        ModelView mv = adapter.handle(request, response, handler);

//        (v2) 추가된 부분
//        각 컨트롤러의 jsp를 실행한다.(view를 처리한다.)
//        view.render(request,response);

//        (v3) 에서는 getViewName을 하면 논리 주소만 가져온다.
//        String viewName = mv.getViewName();

//        (v3) 그래서 viewResolver 라는 메서드로 물리 주소로 변환시켜준다.
//        MyView view = viewResolver(viewName);
//        (v5) 어댑터에서 반환 받은 ModelView 에서 상대주소를 가져온다.
        MyView view = viewResolver(mv.getViewName());

//        (v3) render 에서는 model 정보를 매개변수로 받아준다.
//        자세한 설명은 MyView의 render 메서드에 주석 참고
//        view.render(mv.getModel(), request, response);
//        view.render(model,request,response);
//        (v5) v4에서는 모델을 파라미터로 받아서 그대로 넘겨줬지만,
//        (v5) 에서는 ModelView 에서 가져와야한다.
        view.render(mv.getModel(),request,response);
    }

//    (v3) createParamMap 주석 start
//    request 객체에 있는 것을 paramMap에 넘겨주는 메서드
//    key 는 request 객체에 있는 paramName이 되고,
//    request 객체의 paramName의 velue가 paramMap의 velue가 된다.
//    (v3) createPramMap 주석 end
//    (v5) v5 버전에서는 어댑터에서 처리한다.
//    private Map<String, String> createParamMap(HttpServletRequest request) {
//        Map<String, String> paramMap = new HashMap<>();
//        request.getParameterNames().asIterator()
//                .forEachRemaining(paramName -> paramMap.put(
//                                paramName, request.getParameter(paramName)
//                        )
//                );
//        return paramMap;
//    }
//    (v5)
    private Object getHandler(HttpServletRequest request) {
//        (v5) 현재 주소를 가져와
        String requestURI = request.getRequestURI();
//        (v5) 그 주소에 맞는 컨트롤러 호출
        return handlerMappingMap.get(requestURI);
    }
//    (v5) 어댑터를 찾는 메서드
    private MyHandlerAdapter getHandlerAdapter(Object handler) {
//        (v5) handlerAdapters 에 들어 있는 모든 어댑터
        for (MyHandlerAdapter adapter : handlerAdapters) {
//            (v5) suppoerts 메서드를 활용해서 컨트롤러에 맞는 어댑터인지 판단
            if (adapter.supports(handler)) {
                return adapter;
            }
//            (v5) 만약 맞는 어댑터가 없으면 예외처리
        } throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

//        (v3) viewResolver 주석 start
//    논리주소를 매개변수로받아 물리주소로 변환시켜준다.
//    viewResolver 주석 end
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}