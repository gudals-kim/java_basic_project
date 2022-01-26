package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //aop로 동작해라
@Component //스프링이 관리해줘
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")//룰 적용부분
    // 이건 controller 의 하위에 모두 적용
    // 보통 특정 컨트롤러, 패키지, 서비스의 하위에 룰을 적용시킨다.
    private void cut(){

    }


    @Before("cut()")//cut 메서드가 실행되는 지점에 실행하면서 메서드 이름과 매개변수들의 정보
    public void before(JoinPoint joinPoint){
        //joinpoint는 들어가는 지점에 대한 정보들을 가지고 잇는 객체

        //사용 메서드 이름 찍기
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("사용 메서드 이름 : "+method.getName());


        Object[] args = joinPoint.getArgs();//메서드에 들어가 있는 매개변수의 배열
        for(Object obj : args){
            System.out.println("type : "+obj.getClass().getSimpleName());
            System.out.println("value : "+obj);
        }
    }

    //cut메서드가 리턴을 할때 어떠한 값이 리턴이 되는지 로그 찍기
    @AfterReturning(value = "cut()",returning = "returnobj")
    public void afterReturn(JoinPoint joinPoint,Object returnobj){
        System.out.println("return obj : "+returnobj);
    }
}
