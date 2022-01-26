package com.example.aop.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//특정 메서드의 실행 시간을 찍을것
@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")//룰 적용부분
    // 이건 controller 의 하위에 모두 적용
    // 보통 특정 컨트롤러, 패키지, 서비스의 하위에 룰을 적용시킨다.
    private void cut(){
    }

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("걸린시간 : "+ stopWatch.getTotalTimeSeconds());
    }

}
