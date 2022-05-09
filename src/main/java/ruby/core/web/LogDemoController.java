package ruby.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ruby.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    /**
     * MyLogger bean 의 scope 를 request 로 설정해놓으면 현재 클래스를 통해 bean 을 생성할 때 의존관계 주입을 할 수 없어 오류가 발생한다
     *  - request 가 발생하기 전 myLogger 의 bean 객체는 생성되지 않기 때문
     *  - 해당 문제를 해결하기 위해서 @Scope 의 proxyMode 프로퍼티의 옵션을 설정해서 의존관계 주입 시점에 proxy 객체를 주입시켜 놓는다.
     */
    private final MyLogger myLogger;


    @RequestMapping("log-demo")
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
