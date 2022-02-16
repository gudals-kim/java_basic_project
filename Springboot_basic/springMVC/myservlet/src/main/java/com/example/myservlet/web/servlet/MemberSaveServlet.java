package com.example.myservlet.web.servlet;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {
    //멤버 저장소를 생성한다(싱글톤이기 때문에 한 객체에 접근하는것 뿐이다.)
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //폼으로 보내준 요청에서 username과 age를 가져옴
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        //멤버를 생성해준다.
        Member member = new Member(username, age);
        //멤버를 저장한다.
        memberRepository.save(member);


        //기본 응답 헤더 설정
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //기본 응답 헤더 설정 끝

        // 응답으로 화면 출력
        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+member.getId()+"</li>\n" +
                " <li>username="+member.getUsername()+"</li>\n" +
                " <li>age="+member.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
