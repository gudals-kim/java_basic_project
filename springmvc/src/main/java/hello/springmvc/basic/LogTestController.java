package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Rescontroller 설명
//기존 Controller 는 String 을 반환하면 view의 이름(경로)으로 인식이 된다. 그래서 view를 찾아서 랜더링시킨다.
//RestController는 반환값으로 뷰를 찾는 것이 아닌, HTTP 메시지 바디에 바로 입력한다. 따라서 그냥 문자 그 자체를 반환한다.
@Slf4j
@RestController
public class LogTestController {
//    원래는 이런식으로 로그를 생성해서 사용해야하지만, @Slf4j 어노테이션을 사용하면 바로 사용가능하다.
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
//      로그 정보 날짜/시간/INFO/프로세스아이디/현재실행한쓰레드/호출한컨트롤러이름/메시지
//        log.trace(로컬)
        log.trace("trace log={}", name);
//        log.debug(개발서버)
        log.debug("debug log={}", name);
//        log.info(중요정보, 운영서버)
        log.info("info log={}", name);
//        log.warn(경고)
        log.warn("warn log={}", name);
//        log.error(위험)
        log.error("error log={}", name);




        return "ok";

    }
}
