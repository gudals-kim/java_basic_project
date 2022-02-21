package com.example.myservlet.web.frontcontroller.v1.controller;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import com.example.myservlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //username과 age를 가져옴
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        //가져온 값으로 멤버를 생성해준다.
        Member member = new Member(username, age);
        //멤버를 저장한다.
        memberRepository.save(member);

        //MVC 패턴에서 추가
        //model에 데이터 보관한다.
        request.setAttribute("member",member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
