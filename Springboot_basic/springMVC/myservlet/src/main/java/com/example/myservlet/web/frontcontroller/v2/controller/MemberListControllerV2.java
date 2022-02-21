package com.example.myservlet.web.frontcontroller.v2.controller;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import com.example.myservlet.web.frontcontroller.MyView;

import com.example.myservlet.web.frontcontroller.v2.ControllerV2;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        //store 에 저장된 모든 멤버를 members 리스트에 저장

        request.setAttribute("members",members);
        //저장된 members 리스트를 model에 저장

//        (v1) view 처리 코드
//        String viewPath = "/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
//        (v2) view 처리 코드
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
