package com.example.myservlet.web.springMVC.v3;

import com.example.myservlet.domain.Member;
import com.example.myservlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

//    (v1~v2) ModelAndView에 상대주소를 넣고 반환
//    (v3)new-form 컨트롤러 반환값을 String으로 하면 상대주소만 넘겨줄수있다. ModelAndView->String
//    (v3) 또한 value = "매핑주소", method = 메서드 타입 (Get,Post,put,delete)를 지정해줄수 있다.
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String newForm() {
//        (v1~v2) ModelAndView에 주소와 데이터를 넘긴다.
//        (v3) 상대 경로만 리턴한다 string으로 반환하면 된다.
//        return new ModelAndView("new-form");
        return "new-form";
    }

//    (v1~v2) code
//    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
//    (v3) postMapping 애노테이션을 쓰면 value =" ", method = "post" 와 같은 의미이다.
    @PostMapping("/save")
        public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
//        (v1~v2) 에서는 이런식으로 파라미터를 받아왔다.
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//        (v3) RequestParam으로 Http 요청 파라미터를 받을 수 있다.
//        (v3) RequestParma("username") = request.getParameter("username") 이다.
        Member member = new Member(username, age);
        memberRepository.save(member);
//        (v1~v2) 에서는 ModelAndView를 생성해서 거기에 경로와 데이터를 넣어서 보냈다
//        ModelAndView mv = new ModelAndView("save-result");
//        mv.addObject("member", member);
//        (v3) 이제 모델이 파라미터로 넘어오기 때문에, 모델에 데이터만 넣어주면 된다. 경로는 리턴
        model.addAttribute("member",member);
        return "save-result";
    }
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }
}

