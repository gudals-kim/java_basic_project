package com.example.myservlet.web.frontcontroller.v4.controller;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
//        (v1~v2)username과 age를 가져옴
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));

//        (v3) request 객체에서 가져오는것이 아닌 ModelView의 ParamMap에서 가져온다.
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

//        가져온 값으로 멤버를 생성해준다.
        Member member = new Member(username, age);
//        멤버를 저장한다.
        memberRepository.save(member);

//        MVC 패턴에서 추가
//        (v1~v2)model에 데이터 보관한다.
//        request.setAttribute("member",member);
//        (v3) 상대 경로를 지정해준 ModelView 객체를 생성해주고
//        ModelView mv = new ModelView("save-result");
//        (v3)그 객체에서 모델을 가져와 member 를 넣어준다.
//        mv.getModel().put("member",member);

//        (v4) 모델이 파라미터로 전달되기 때문에 모델을 직접 생성하지 않아도 된다.
//        (v4) 또한 model에 생성된 member를 넣어준다.
        model.put("member", member);

//        (v1) view 처리 코드
//        String viewPath = "/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);

//        (v2) view 처리 코드
//        return new MyView("/WEB-INF/views/save-result.jsp");
//        (v3) modelView 객체를 반환해준다.
//        return mv;
//        (v4) 논리 이름만 반환한다.
        return "save-result";
    }
}
