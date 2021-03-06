package com.example.myservlet.web.springMVC.v1;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import com.example.myservlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age); System.out.println("member = " + member);
        memberRepository.save(member);
//        (v1) 스프링에서 제공하는 ModelAndView 객체 생성
        ModelAndView mv = new ModelAndView("save-result");
//        (v1) ModelAndView에 데이터를 추가할땐 addObject() 을 사용하면 된다.
        mv.addObject("member", member);
        return mv;
    }
}
