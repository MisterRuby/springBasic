package ruby.core.singleton;

/**
 * 싱글톤 패턴
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 외부에서 생성자를 통해 객체를 생성하지 못하도록 막는다
    private SingletonService () {}

    public static SingletonService getInstance() {
        return instance;
    }
}
