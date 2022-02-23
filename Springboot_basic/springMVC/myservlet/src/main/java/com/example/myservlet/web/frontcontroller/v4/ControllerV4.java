package com.example.myservlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    //(v2)void -> MyView 로 반환하게 만듦
    //(v3) MyView -> ModelView 로 반환하게 바꾼다.
    //(v3) Map<Sting, Sting> 을 매개변수로 받아준다.
    //(v4) model 객체는 파라미터로 전달되기 때문에, 뷰 이름만 반환해주면 된다.
    String process(Map<String ,String> paramMap, Map<String, Object> model);
}
