package com.example.myservlet.web.springMVC.v2;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
//(v1) Controller 애노테이션의 기능
//1. 현재 클래스를 자동으로 스프링 빈에 등록한다.
//2. 스프링 MVC에서 컨트롤러로 인식한다.
//(v2) 기존 에는 /springmvc/v2/... 의 부분의 주소가 계속 중복되었기 때문에 클래스단위에 주소를 입력해준다.
@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
//    (v2) 각 컨트롤러의 주소를 입력해 준다
//    이렇게 되면 /spring/v2/new-form 으로 매핑된다.
    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age); System.out.println("member = " + member);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }

    @RequestMapping
    public ModelAndView members(){
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }
}
