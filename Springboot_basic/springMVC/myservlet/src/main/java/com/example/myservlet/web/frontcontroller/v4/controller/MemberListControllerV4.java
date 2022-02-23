package com.example.myservlet.web.frontcontroller.v4.controller;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import com.example.myservlet.web.frontcontroller.ModelView;
import com.example.myservlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
//      store 에 저장된 모든 멤버를 members 리스트에 저장
        List<Member> members = memberRepository.findAll();

        //(v1~v2)저장된 members 리스트를 model에 저장
//        request.setAttribute("members",members);

//        (v3) 상대경로를 지정해준 ModelView 객체 생성
//        ModelView mv = new ModelView("members");
//        (v3) 저장된 members 리스트를 model(modelview)에 저장
//        mv.getModel().put("members",members);
//        (v4) 생성된 members 객체를 model에 넣어준다.
        model.put("members",members);

//        (v1) view 처리 코드
//        String viewPath = "/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
//        (v2) view 처리 코드
//        return new MyView("/WEB-INF/views/members.jsp");
//        (v3) ModelView 객체를 리턴한다.
//        return mv;
//        (v4) 상대 경로만 리턴한다.
        return "members";
    }
}
