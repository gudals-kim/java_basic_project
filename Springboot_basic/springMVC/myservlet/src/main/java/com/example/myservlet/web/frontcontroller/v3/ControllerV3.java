package com.example.myservlet.web.frontcontroller.v3;

import com.example.myservlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //(v2)void -> MyView 로 반환하게 만듦
    //(v3) MyView -> ModelView 로 반환하게 바꾼다.
    //(v3) Map<Sting, Sting> 을 매개변수로 받아준다.
    ModelView process(Map<String, String> paramMap);
}
