package ruby.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 빈 생명주기 콜백 예제
 */
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    public NetworkClient() {
        System.out.println("NetworkClient.NetworkClient");
    }

    /**
     * 최신 스프링에서 @PostConstruct, @PreDestroy 사용을 권장함
     *  - 컴포넌트 스캔을 활용한 클래스에 사용하기 적합(@Component, @Service, @Controller 등)
     *  - 외부 라이브러리의 클래스에는 활용하지 못하므로 해당 케이스는 @Bean 을 통한 initMethod, destroyMethod 지정 방법을 사용
     */
    // 의존관계 주입 후 호출
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
    }

    // 빈 소멸 전 호출
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
    }




    /**
     * InitializingBean, DisposableBean 은 스프링 전용 인터페이스의 단점
     *  - 해당 코드가 스프링 전용 인터페이스에 의존함
     *  - 초기화, 소멸 메소드의 이름을 변경할 수 없음
     *  - 외부 라이브러리에 해당 인터페이스를 적용할 수 없음
     *
     *  - 위의 단점들 때문에 InitializingBean, DisposableBean 을 이용한 방법은 사용하지 않고 다른 방법을 사용
    */
    
    /**
     * 의존관계 주입이 끝나면 해당 메서드가 호출
     * - InitializingBean 의 Override 메서드
     * @throws Exception

    @Override
    public void afterPropertiesSet() throws Exception {
        // 생성자는 메모리를 할당해서 객체를 생성하는 책임을 가진다.
        // 따라서 생성자 안에서 객체 내부의 값을 설정하거나 초기화 작업까지 처리하는 것에 대해서 고민할 필요가 있다.
        // 가벼운 초기화 및 설정이 아니라면 분리를 고려할 것
        connect();
        call("초기화 연결 메시지");
    }
     */

    /**
     * 빈 객체가 소멸하기 전 해당 메서드가 호출
     * - DisposableBean 의 Override 메서드
     * @throws Exception
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
     */
}
