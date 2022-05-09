package ruby.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "ruby.core"
        // 해당 패키지 및 하위 패키지를 탐색해 @Component 가 붙은 클래스들을 스프링 빈으로 등록시킨다.
        // basePackages 를 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 탐색 시작 위치가 된다.
)
public class AutoAppConfig {
}
