package ruby.core.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 빈의 이벤트 라이프 사이클
 *  스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸 전 콜백 -> 스프링 종료
 *      초기화 콜백 : 빈이 생성되고 빈의 의존 관계 주입이 완료된 후 호출
 *      소멸 전 콜백 : 빈이 소멸되기 직전 호출
 *
 *      생성자를 통한 주입의 경우 빈 생성 시점에 의존관계 주입이 발생
 */
public class BeanLifeCycleTest {

    @Test
    @DisplayName("PostConstruct & PreDestroy 테스트")
    void testLifeCycle() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        System.out.println("ac.close 호출 전");
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        /**
         * initMethod, destroyMethod 메소드를 지정
         *  - 빈의 의존관계 주입 후, 소멸 전 지정한 메소드들을 호출한다.
         *  - 메소드 이름을 자유롭게 설정할 수 있다.
         *  - 스프링 빈이 스프링 전용 코드에 의존하지 않는다.
         *  - 외부 라이브러리에서 초기화, 종료 메서드를 적용할 수 있다.(외부 라이브러리의 클래스의 메서드를 지정 가능)
         *  - 종료 메서드 추론 기능
         *      - destroyMethod 를 지정하지 않아도 기본값으로 close, shutdown 이름의 메서드를 자동으로 호출
         *          - 라이브러리의 대부분이 종료메서드로 close, shutdown 이름을 사용
         *      - 추론 기능을 사용하고 싶지 않다면 destroyMethod="" 으로 빈 문자열 값으로 설정한다.
         *
         *  최근에는 위의 방법을 사용하지 않고 @PoseConstruct, @PreDestroy 를 사용
         */
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            return networkClient;
        }
    }
}
